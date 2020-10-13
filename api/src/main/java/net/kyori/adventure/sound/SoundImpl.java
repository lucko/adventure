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
package net.kyori.adventure.sound;

import net.kyori.adventure.util.ShadyPines;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

abstract class SoundImpl implements Sound {
  private final Source source;
  private final float volume;
  private final float pitch;

  SoundImpl(final @NonNull Source source, final float volume, final float pitch) {
    this.source = source;
    this.volume = volume;
    this.pitch = pitch;
  }

  @Override
  public @NonNull Source source() {
    return this.source;
  }

  @Override
  public float volume() {
    return this.volume;
  }

  @Override
  public float pitch() {
    return this.pitch;
  }

  @Override
  public boolean equals(final @Nullable Object other) {
    if(this == other) return true;
    if(!(other instanceof SoundImpl)) return false;
    final SoundImpl that = (SoundImpl) other;
    return this.name().equals(that.name())
      && this.source == that.source
      && ShadyPines.equals(this.volume, that.volume)
      && ShadyPines.equals(this.pitch, that.pitch);
  }

  @Override
  public int hashCode() {
    int result = this.name().hashCode();
    result = (31 * result) + this.source.hashCode();
    result = (31 * result) + Float.hashCode(this.volume);
    result = (31 * result) + Float.hashCode(this.pitch);
    return result;
  }

  @Override
  public @NonNull String toString() {
    return "SoundImpl{" +
      "name=" + this.name() +
      ", source=" + this.source +
      ", volume=" + this.volume +
      ", pitch=" + this.pitch +
      '}';
  }
}
