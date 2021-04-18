/*
 * This file is part of examination, licensed under the MIT License.
 *
 * Copyright (c) 2018-2021 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.adventure.util.examination;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An abstract implementation of an examiner.
 *
 * @param <R> the result type
 * @since 1.0.0
 */
public abstract class AbstractExaminer<R> implements Examiner<R> {
  @Override
  public @NonNull R examine(final @Nullable Object value) {
    if(value == null) {
      return this.nil();
    } else if(value instanceof String) {
      return this.examine((String) value);
    } else if(value instanceof Examinable) {
      return this.examine((Examinable) value);
    } else if(value instanceof Collection<?>) {
      return this.collection((Collection<?>) value);
    } else if(value instanceof Map<?, ?>) {
      return this.map((Map<?, ?>) value);
    } else if(value.getClass().isArray()) {
      final Class<?> type = value.getClass().getComponentType();
      if(type.isPrimitive()) {
        if(type == boolean.class) {
          return this.examine((boolean[]) value);
        } else if(type == byte.class) {
          return this.examine((byte[]) value);
        } else if(type == char.class) {
          return this.examine((char[]) value);
        } else if(type == double.class) {
          return this.examine((double[]) value);
        } else if(type == float.class) {
          return this.examine((float[]) value);
        } else if(type == int.class) {
          return this.examine((int[]) value);
        } else if(type == long.class) {
          return this.examine((long[]) value);
        } else if(type == short.class) {
          return this.examine((short[]) value);
        }
      }
      return this.array((Object[]) value);
    } else if(value instanceof Boolean) {
      return this.examine(((Boolean) value).booleanValue());
    } else if(value instanceof Character) {
      return this.examine(((Character) value).charValue());
    } else if(value instanceof Number) {
      if(value instanceof Byte) {
        return this.examine(((Byte) value).byteValue());
      } else if(value instanceof Double) {
        return this.examine(((Double) value).doubleValue());
      } else if(value instanceof Float) {
        return this.examine(((Float) value).floatValue());
      } else if(value instanceof Integer) {
        return this.examine(((Integer) value).intValue());
      } else if(value instanceof Long) {
        return this.examine(((Long) value).longValue());
      } else if(value instanceof Short) {
        return this.examine(((Short) value).shortValue());
      }
    } else if(value instanceof BaseStream<?, ?>) {
      if(value instanceof Stream<?>) {
        return this.stream((Stream<?>) value);
      } else if(value instanceof DoubleStream) {
        return this.stream((DoubleStream) value);
      } else if(value instanceof IntStream) {
        return this.stream((IntStream) value);
      } else if(value instanceof LongStream) {
        return this.stream((LongStream) value);
      }
    }
    return this.scalar(value);
  }

  /**
   * Examines an array.
   *
   * @param array the array
   * @param <E> the element type
   * @return the result from examining an array
   */
  private <E> @NonNull R array(final @NonNull E[] array) {
    return this.array(array, Arrays.stream(array).map(this::examine));
  }

  /**
   * Examines an array.
   *
   * @param array the array
   * @param elements the array elements
   * @param <E> the element type
   * @return the result from examining an array
   */
  protected abstract <E> @NonNull R array(final @NonNull E[] array, final @NonNull Stream<R> elements);

  /**
   * Examines a collection.
   *
   * @param collection the collection
   * @param <E> the element type
   * @return the result from examining a collection
   */
  private <E> @NonNull R collection(final @NonNull Collection<E> collection) {
    return this.collection(collection, collection.stream().map(this::examine));
  }

  /**
   * Examines a collection.
   *
   * @param collection the collection
   * @param elements the collection elements
   * @param <E> the element type
   * @return the result from examining a collection
   */
  protected abstract <E> @NonNull R collection(final @NonNull Collection<E> collection, final @NonNull Stream<R> elements);

  @Override
  public @NonNull R examine(final @NonNull String name, final @NonNull Stream<? extends ExaminableProperty> properties) {
    return this.examinable(name, properties.map(property -> new AbstractMap.SimpleImmutableEntry<>(property.name(), property.examine(this))));
  }

  /**
   * Examines an examinable.
   *
   * @param name the examinable name
   * @param properties the examinable properties
   * @return the result from examining an examinable
   */
  protected abstract @NonNull R examinable(final @NonNull String name, final @NonNull Stream<Map.Entry<String, R>> properties);

  /**
   * Examines a map.
   *
   * @param map the map
   * @param <K> the key type
   * @param <V> the value type
   * @return the result from examining a map
   */
  private <K, V> @NonNull R map(final @NonNull Map<K, V> map) {
    return this.map(map, map.entrySet().stream().map(entry -> new AbstractMap.SimpleImmutableEntry<>(this.examine(entry.getKey()), this.examine(entry.getValue()))));
  }

  /**
   * Examines a map.
   *
   * @param map the map
   * @param entries the map entries
   * @param <K> the key type
   * @param <V> the value type
   * @return the result from examining a map
   */
  protected abstract <K, V> @NonNull R map(final @NonNull Map<K, V> map, final @NonNull Stream<Map.Entry<R, R>> entries);

  /**
   * Examines {@code null}.
   *
   * @return the result from examining {@code null}
   */
  protected abstract @NonNull R nil();

  /**
   * Examines a scalar value.
   *
   * @param value the scalar value
   * @return the result from examining a scalar
   */
  protected abstract @NonNull R scalar(final @NonNull Object value);

  /**
   * Examines a stream.
   *
   * @param stream the stream
   * @param <T> the type
   * @return the result from examining a stream
   */
  protected abstract <T> @NonNull R stream(final @NonNull Stream<T> stream);

  /**
   * Examines a stream.
   *
   * @param stream the stream
   * @return the result from examining a stream
   */
  protected abstract @NonNull R stream(final @NonNull DoubleStream stream);

  /**
   * Examines a stream.
   *
   * @param stream the stream
   * @return the result from examining a stream
   */
  protected abstract @NonNull R stream(final @NonNull IntStream stream);

  /**
   * Examines a stream.
   *
   * @param stream the stream
   * @return the result from examining a stream
   */
  protected abstract @NonNull R stream(final @NonNull LongStream stream);
}
