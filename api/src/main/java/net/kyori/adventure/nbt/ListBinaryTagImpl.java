/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2020 KyoriPowered
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
package net.kyori.adventure.nbt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class ListBinaryTagImpl implements ListBinaryTag {
  static final ListBinaryTag EMPTY = new ListBinaryTagImpl(BinaryTagTypes.END, Collections.emptyList());
  private final List<? extends BinaryTag> tags;
  private final BinaryTagType<? extends BinaryTag> type;
  private final int hashCode;

  ListBinaryTagImpl(final BinaryTagType<? extends BinaryTag> type, final List<? extends BinaryTag> tags) {
    this.tags = tags;
    this.type = type;
    this.hashCode = tags.hashCode();
  }

  @Override
  public @NonNull BinaryTagType<? extends BinaryTag> listType() {
    return this.type;
  }

  @Override
  public int size() {
    return this.tags.size();
  }

  @Override
  public @NonNull BinaryTag get(@NonNegative final int index) {
    return this.tags.get(index);
  }

  @Override
  public @NonNull ListBinaryTag set(final int index, final @NonNull BinaryTag newTag, final @Nullable Consumer<BinaryTag> removedConsumer) {
    return this.edit(tags -> {
      final BinaryTag oldTag = tags.set(index, newTag);
      if(removedConsumer != null) {
        removedConsumer.accept(oldTag);
      }
    }, newTag.type());
  }

  @Override
  public @NonNull ListBinaryTag remove(final int index, final @Nullable Consumer<BinaryTag> removedConsumer) {
    return this.edit(tags -> {
      final BinaryTag tag = tags.remove(index);
      if(removedConsumer != null) {
        removedConsumer.accept(tag);
      }
    }, null);
  }

  @Override
  public @NonNull ListBinaryTag add(final BinaryTag tag) {
    return this.edit(tags -> {
      noAddEnd(tag);
      if(this.type != BinaryTagTypes.END) {
        mustBeSameType(tag, this.type);
      }
      tags.add(tag);
    }, tag.type());
  }

  // An end tag cannot be an element in a list tag
  static void noAddEnd(final BinaryTag tag) {
    if(tag.type() == BinaryTagTypes.END) {
      throw new IllegalArgumentException(String.format("Cannot add a %s to a %s", BinaryTagTypes.END, BinaryTagTypes.LIST));
    }
  }

  // Cannot have different element types in a list tag
  static void mustBeSameType(final BinaryTag tag, final BinaryTagType<? extends BinaryTag> type) {
    if(tag.type() != type) {
      throw new IllegalArgumentException(String.format("Trying to add tag of type %s to list of %s", tag.type(), type));
    }
  }

  private ListBinaryTag edit(final Consumer<List<BinaryTag>> consumer, final @Nullable BinaryTagType<? extends BinaryTag> maybeType) {
    final List<BinaryTag> tags = new ArrayList<>(this.tags);
    consumer.accept(tags);
    BinaryTagType<? extends BinaryTag> type = this.type;
    // set the type if it has not yet been set
    if(maybeType != null && type == BinaryTagTypes.END) {
      type = maybeType;
    }
    return new ListBinaryTagImpl(type, tags);
  }

  @Override
  public Iterator<BinaryTag> iterator() {
    final Iterator<? extends BinaryTag> iterator = this.tags.iterator();
    return new Iterator<BinaryTag>() {
      @Override
      public boolean hasNext() {
        return iterator.hasNext();
      }

      @Override
      public BinaryTag next() {
        return iterator.next();
      }

      @Override
      public void forEachRemaining(final Consumer<? super BinaryTag> action) {
        iterator.forEachRemaining(action);
      }
    };
  }

  @Override
  public void forEach(final Consumer<? super BinaryTag> action) {
    this.tags.forEach(action);
  }

  @Override
  public Spliterator<BinaryTag> spliterator() {
    return Spliterators.spliterator(this.tags, Spliterator.ORDERED | Spliterator.IMMUTABLE);
  }

  @Override
  public boolean equals(final Object that) {
    return this == that || (that instanceof ListBinaryTagImpl && this.tags.equals(((ListBinaryTagImpl) that).tags));
  }

  @Override
  public int hashCode() {
    return this.hashCode;
  }

  @Override
  public @NonNull String toString() {
    return "ListBinaryTagImpl{" +
      "tags=" + this.tags +
      ", type=" + this.type +
      '}';
  }
}
