/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/CodeEditor
 *    Copyright (C) 2020-2021  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */
package io.github.rosemoe.sora.widget.schemes;

import io.github.rosemoe.sora.widget.EditorColorScheme;

/**
 * ColorScheme for editor - Nord theme
 * Picked from Nord palette (https://www.nordtheme.com)
 */
public class SchemeNord extends EditorColorScheme {

    @Override
    public void applyDefault() {
        super.applyDefault();
        setColor(ANNOTATION, 0xffb48ead);
        setColor(FUNCTION_NAME, 0xff88c0d0);
        setColor(IDENTIFIER_NAME, 0xffd8dee9);
        setColor(IDENTIFIER_VAR, 0xffd8dee9);
        setColor(LITERAL, 0xffa3be8c);
        setColor(OPERATOR, 0xffd8dee9);
        setColor(COMMENT, 0xff636d83);
        setColor(KEYWORD, 0xff81a1c1);
        setColor(WHOLE_BACKGROUND, 0xff2e3440);
        setColor(TEXT_NORMAL, 0xffd8dee9);
        setColor(LINE_NUMBER_BACKGROUND, 0xff2e3440);
        setColor(LINE_NUMBER, 0xff4c566a);
        setColor(LINE_DIVIDER, 0xff4c566a);
        setColor(SCROLL_BAR_THUMB, 0xff4c566a);
        setColor(SCROLL_BAR_THUMB_PRESSED, 0xff81a1c1);
        setColor(SELECTED_TEXT_BACKGROUND, 0xff4c566a);
        setColor(MATCHED_TEXT_BACKGROUND, 0xff5e81ac);
        setColor(CURRENT_LINE, 0xff3b4252);
        setColor(SELECTION_INSERT, 0xffffffff);
        setColor(SELECTION_HANDLE, 0xffffffff);
        setColor(BLOCK_LINE, 0xff4c566a);
        setColor(BLOCK_LINE_CURRENT, 0);
        setColor(NON_PRINTABLE_CHAR, 0xff4c566a);
    }

}