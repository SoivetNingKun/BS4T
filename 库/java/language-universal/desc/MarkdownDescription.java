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
package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;

/**
 * Markdown language description for sora-editor
 *
 * @author Rose
 */
public class MarkdownDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        // Markdown 中的特殊标记字符（如 *, -, >, #, `, 等）可作为运算符处理
        if (length == 1) {
            char c = characters[0];
            return c == '*' || c == '-' || c == '+' || c == '>' || c == '#' ||
                   c == '`' || c == '|' || c == '~' || c == '^' || c == '_' ||
                   c == '[' || c == ']' || c == '(' || c == ')' || c == '!' ||
                   c == ':' || c == '.' || c == ',' || c == '<' || c == '>';
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        // Markdown 没有原生行注释，可根据需要支持 HTML 注释 <!-- ... --> 但那是块注释
        return false;
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        // 支持 HTML 风格的块注释：<!--
        return a == '<' && b == '!';
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        // 支持 HTML 风格的块注释结束：-->
        return a == '-' && b == '>';
    }

    @Override
    public String[] getKeywords() {
        // Markdown 语法关键词（标记符），用于高亮
        return new String[]{
            "#", "##", "###", "####", "#####", "######",
            "-", "*", "+", ">", "```", "~~~",
            "[", "]", "(", ")", "!", "**", "__", "*", "_",
            "|", ":-", "-:", ":-:", "~~", "^", "`", "    "
        };
    }

    @Override
    public boolean useTab() {
        // Markdown 通常使用空格缩进（如列表缩进 2 或 4 空格）
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        // 对标题、列表等可定义缩进增量，简单返回 0 表示不自动缩进
        switch (operator) {
            case "#":
            case "##":
            case "###":
            case "####":
            case "#####":
            case "######":
                return 0; // 标题一般不自动缩进
            case "-":
            case "*":
            case "+":
                return 2; // 列表项后建议缩进 2 空格
            default:
                return 0;
        }
    }

    @Override
    public boolean isSupportBlockLine() {
        // 支持代码块折叠（基于 ``` 或 缩进块）
        return true;
    }

    @Override
    public boolean isBlockStart(String operator) {
        // 代码块开始标记：``` 或者 ~~~
        return "```".equals(operator) || "~~~".equals(operator);
    }

    @Override
    public boolean isBlockEnd(String operator) {
        // 代码块结束标记同开始标记
        return "```".equals(operator) || "~~~".equals(operator);
    }
}