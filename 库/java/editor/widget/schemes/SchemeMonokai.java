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
 * ColorScheme for editor
 * picked from Monokai
 */
public class SchemeMonokai extends EditorColorScheme {

    @Override
    public void applyDefault() {
        super.applyDefault();
        setColor(ANNOTATION, 0xff66d9ef);
        setColor(FUNCTION_NAME, 0xffa6e22e);
        setColor(IDENTIFIER_NAME, 0xfff8f8f2);
        setColor(IDENTIFIER_VAR, 0xfff8f8f2);
        setColor(LITERAL, 0xffe6db74);
        setColor(OPERATOR, 0xfff8f8f2);
        setColor(COMMENT, 0xff75715e);
        setColor(KEYWORD, 0xfff92672);
        setColor(WHOLE_BACKGROUND, 0xff272822);
        setColor(TEXT_NORMAL, 0xfff8f8f2);
        setColor(LINE_NUMBER_BACKGROUND, 0xff272822);
        setColor(LINE_NUMBER, 0xff75715e);
        setColor(LINE_DIVIDER, 0xff3e3d32);
        setColor(SCROLL_BAR_THUMB, 0xff5a5a5a);
        setColor(SCROLL_BAR_THUMB_PRESSED, 0xff8a8a8a);
        setColor(SELECTED_TEXT_BACKGROUND, 0xff49483e);
        setColor(MATCHED_TEXT_BACKGROUND, 0xff75715e);
        setColor(CURRENT_LINE, 0xff3e3d32);
        setColor(SELECTION_INSERT, 0xffffffff);
        setColor(SELECTION_HANDLE, 0xffffffff);
        setColor(BLOCK_LINE, 0xff3e3d32);
        setColor(BLOCK_LINE_CURRENT, 0);
        setColor(NON_PRINTABLE_CHAR, 0xff75715e);
    }

}