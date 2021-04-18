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

import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An examiner.
 *
 * @param <R> the result type
 * @since 1.0.0
 */
public interface Examiner<R> {
  /**
   * Examines an examinable.
   *
   * @param examinable the examinable
   * @return the result
   * @since 1.1.0
   */
  default @NonNull R examine(final @NonNull Examinable examinable) {
    return this.examine(examinable.examinableName(), examinable.examinableProperties());
  }

  /**
   * Examines.
   *
   * @param name the examinable name
   * @param properties the examinable properties
   * @return the result
   * @since 1.1.0
   */
  @NonNull R examine(final @NonNull String name, final @NonNull Stream<? extends ExaminableProperty> properties);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final @Nullable Object value);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final boolean value);

  /**
   * Examines.
   *
   * @param values the values to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final boolean@Nullable[] values);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final byte value);

  /**
   * Examines.
   *
   * @param values the values to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final byte@Nullable[] values);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final char value);

  /**
   * Examines.
   *
   * @param values the values to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final char@Nullable[] values);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final double value);

  /**
   * Examines.
   *
   * @param values the values to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final double@Nullable[] values);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final float value);

  /**
   * Examines.
   *
   * @param values the values to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final float@Nullable[] values);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final int value);

  /**
   * Examines.
   *
   * @param values the values to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final int@Nullable[] values);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final long value);

  /**
   * Examines.
   *
   * @param values the values to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final long@Nullable[] values);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final short value);

  /**
   * Examines.
   *
   * @param values the values to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final short@Nullable[] values);

  /**
   * Examines.
   *
   * @param value the value to examine
   * @return the result
   * @since 1.0.0
   */
  @NonNull R examine(final @Nullable String value);
}
