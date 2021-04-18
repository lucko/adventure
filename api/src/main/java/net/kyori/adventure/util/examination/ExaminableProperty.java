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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An examinable property.
 *
 * @since 1.0.0
 */
public abstract class ExaminableProperty {
  private ExaminableProperty() {
  }

  /**
   * Gets the name.
   *
   * @return the name
   * @since 1.0.0
   */
  public abstract @NonNull String name();

  /**
   * Gets the value.
   *
   * @param examiner the examiner
   * @param <R> the result type
   * @return the value
   * @since 1.0.0
   */
  public abstract <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner);

  @Override
  public String toString() {
    return "ExaminableProperty{" + this.name() + "}";
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final @Nullable Object value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final @Nullable String value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final boolean value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final boolean[] value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final byte value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final byte[] value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final char value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final char[] value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final double value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final double[] value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final float value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final float[] value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final int value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final int[] value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final long value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final long[] value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final short value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }

  /**
   * Creates a property.
   *
   * @param name the name
   * @param value the value
   * @return the property
   * @since 1.0.0
   */
  @SuppressWarnings("DuplicatedCode")
  public static @NonNull ExaminableProperty of(final @NonNull String name, final short[] value) {
    return new ExaminableProperty() {
      @Override
      public @NonNull String name() {
        return name;
      }

      @Override
      public <R> @NonNull R examine(final @NonNull Examiner<? extends R> examiner) {
        return examiner.examine(value);
      }
    };
  }
}
