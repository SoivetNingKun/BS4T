/*
 *    sora-editor - the awesome code editor for Android
 https://github.com/Rosemoe/CodeEditor
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
 * Neon theme inspired by GeekDZ Dark Neon, Utilitybend Neon, etc.
 */
public class SchemeNeon extends EditorColorScheme {

    @Override
    public void applyDefault() {
        super.applyDefault();

        // 背景 & 基础前景 (深空蓝黑背景 + 亮白主色)
        setColor(WHOLE_BACKGROUND, 0xff0a0f1c);          // 深邃太空蓝黑底色
        setColor(TEXT_NORMAL, 0xfff0f4fc);               // 亮白文本

        // === 语法高亮 ===
        // 注释: 柔和灰蓝，降低饱和度减少干扰
        setColor(COMMENT, 0xff5f6a8a);

        // 关键字 (if, else, for, while 等): 霓虹蓝
        setColor(KEYWORD, 0xff00bfff);

        // 字面量/数字/常量: 霓虹橙
        setColor(LITERAL, 0xffff8c00);

        // 运算符: 保持高亮，但非焦点，使用青绿色
        setColor(OPERATOR, 0xff80cbc4);

        // 字符串: 霓虹绿
        setColor(ANNOTATION, 0xff39ff14);
        setColor(IDENTIFIER_NAME, 0xff39ff14);
        setColor(IDENTIFIER_VAR, 0xffffffff);

        // 函数名: 亮紫色
        setColor(FUNCTION_NAME, 0xffbf00ff);

        // === UI 组件 ===
        setColor(LINE_NUMBER_BACKGROUND, 0xff0a0f1c);
        setColor(LINE_NUMBER, 0xff00bfff);
        setColor(LINE_DIVIDER, 0xff2b9eaf);
        setColor(SCROLL_BAR_THUMB, 0xff3e3e42);
        setColor(SCROLL_BAR_THUMB_PRESSED, 0xff9e9e9e);
        setColor(SELECTED_TEXT_BACKGROUND, 0xff3676b8);
        setColor(MATCHED_TEXT_BACKGROUND, 0xff653306);
        setColor(CURRENT_LINE, 0xff464646);
        setColor(SELECTION_INSERT, 0xffffffff);
        setColor(SELECTION_HANDLE, 0xffffffff);
        setColor(BLOCK_LINE, 0xff717171);
        setColor(BLOCK_LINE_CURRENT, 0);
        setColor(NON_PRINTABLE_CHAR, 0xffdddddd);
    }

}