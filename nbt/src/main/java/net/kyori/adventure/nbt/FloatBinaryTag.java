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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A binary tag holding a {@code float} value.
 *
 * @since 4.0.0
 */
public interface FloatBinaryTag extends NumberBinaryTag {
  /**
   * Creates a binary tag holding a {@code float} value.
   *
   * @param value the value
   * @return a binary tag
   * @since 4.0.0
   */
  static @NonNull FloatBinaryTag of(final float value) {
    return new FloatBinaryTagImpl(value);
  }

  @Override
  default @NonNull BinaryTagType<FloatBinaryTag> type() {
    return BinaryTagTypes.FLOAT;
  }

  /**
   * Gets the value.
   *
   * @return the value
   * @since 4.0.0
   */
  float value();
}

final class FloatBinaryTagImpl implements FloatBinaryTag {
  private final float value;

  FloatBinaryTagImpl(final float value) {
    this.value = value;
  }

  @Override
  public float value() {
    return this.value;
  }

  @Override
  public byte byteValue() {
    return (byte) (ShadyPines.floor(this.value) & 0xff);
  }

  @Override
  public double doubleValue() {
    return this.value;
  }

  @Override
  public float floatValue() {
    return this.value;
  }

  @Override
  public int intValue() {
    return ShadyPines.floor(this.value);
  }

  @Override
  public long longValue() {
    return (long) this.value;
  }

  @Override
  public short shortValue() {
    return (short) (ShadyPines.floor(this.value) & 0xffff);
  }

  @Override
  public boolean equals(final @Nullable Object other) {
    if(this == other) return true;
    if(other == null || this.getClass() != other.getClass()) return false;
    final FloatBinaryTagImpl that = (FloatBinaryTagImpl) other;
    return Float.floatToIntBits(this.value) == Float.floatToIntBits(that.value);
  }

  @Override
  public int hashCode() {
    return Float.hashCode(this.value);
  }

  @Override
  public @NonNull String toString() {
    return "FloatBinaryTagImpl{" +
      "value=" + this.value +
      '}';
  }
}
