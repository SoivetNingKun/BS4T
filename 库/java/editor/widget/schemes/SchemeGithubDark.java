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
 * based on GitHub Dark theme
 */
public class SchemeGithubDark extends EditorColorScheme {

    @Override
    public void applyDefault() {
        super.applyDefault();
        // 注解 - 浅蓝色
        setColor(ANNOTATION, 0xff79c0ff);
        // 函数名 - 紫色
        setColor(FUNCTION_NAME, 0xffd2a8ff);
        // 普通标识符 - 默认文本色
        setColor(IDENTIFIER_NAME, 0xffc9d1d9);
        // 变量标识符 - 浅蓝色
        setColor(IDENTIFIER_VAR, 0xff79c0ff);
        // 字面量（字符串、数字等）- 浅蓝色（字符串） / 数字也可单独设置，此处统一定义为字符串色
        setColor(LITERAL, 0xffa5d6ff);
        // 操作符 - 默认文本色
        setColor(OPERATOR, 0xffc9d1d9);
        // 注释 - 灰色
        setColor(COMMENT, 0xff8b949e);
        // 关键字 - 红色/粉色
        setColor(KEYWORD, 0xffff7b72);
        // 整体背景 - GitHub Dark 背景色
        setColor(WHOLE_BACKGROUND, 0xff0d1117);
        // 普通文本 - 浅灰白
        setColor(TEXT_NORMAL, 0xffc9d1d9);
        // 行号背景 - 与编辑器背景一致
        setColor(LINE_NUMBER_BACKGROUND, 0xff0d1117);
        // 行号文字 - 中灰色
        setColor(LINE_NUMBER, 0xff6e7681);
        // 选中区域背景 - 深蓝色（类似 VS Code 深色主题）
        setColor(SELECTION_INSERT, 0xff264f78);
        // 选中手柄颜色 - 与选中背景相同
        setColor(SELECTION_HANDLE, 0xff264f78);
    }

}