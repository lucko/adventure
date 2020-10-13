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
package net.kyori.adventure.text.format;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.util.Index;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An enumeration of decorations which may be applied to a {@link Component}.
 *
 * @since 4.0.0
 */
public enum TextDecoration implements StyleBuilderApplicable, TextFormat {
  /**
   * A decoration which makes text obfuscated/unreadable.
   *
   * @since 4.0.0
   */
  OBFUSCATED("obfuscated"),
  /**
   * A decoration which makes text appear bold.
   *
   * @since 4.0.0
   */
  BOLD("bold"),
  /**
   * A decoration which makes text have a strike through it.
   *
   * @since 4.0.0
   */
  STRIKETHROUGH("strikethrough"),
  /**
   * A decoration which makes text have an underline.
   *
   * @since 4.0.0
   */
  UNDERLINED("underlined"),
  /**
   * A decoration which makes text appear in italics.
   *
   * @since 4.0.0
   */
  ITALIC("italic");

  /**
   * The name map.
   *
   * @since 4.0.0
   */
  public static final Index<String, TextDecoration> NAMES = Index.create(TextDecoration.class, constant -> constant.name);
  private final String name;

  TextDecoration(final String name) {
    this.name = name;
  }

  @Override
  public void styleApply(final Style.@NonNull Builder style) {
    style.decorate(this);
  }

  @Override
  public @NonNull String toString() {
    return this.name;
  }

  /**
   * A state that a {@link TextDecoration} can be in.
   *
   * @since 4.0.0
   */
  public enum State {
    /**
     * State describing the absence of a value.
     *
     * @since 4.0.0
     */
    NOT_SET("not_set"),
    /**
     * State describing a {@code false} value.
     *
     * @since 4.0.0
     */
    FALSE("false"),
    /**
     * State describing a {@code true} value.
     *
     * @since 4.0.0
     */
    TRUE("true");

    private final String name;

    State(final String name) {
      this.name = name;
    }

    @Override
    public @NonNull String toString() {
      return this.name;
    }

    /**
     * Gets a state from a {@code boolean}.
     *
     * @param flag the boolean
     * @return the state
     * @since 4.0.0
     */
    public static @NonNull State byBoolean(final boolean flag) {
      return flag ? TRUE : FALSE;
    }

    /**
     * Gets a state from a {@code Boolean}.
     *
     * @param flag the boolean
     * @return the state
     * @since 4.0.0
     */
    public static @NonNull State byBoolean(final @Nullable Boolean flag) {
      return flag == null ? NOT_SET : byBoolean(flag.booleanValue());
    }
  }
}
