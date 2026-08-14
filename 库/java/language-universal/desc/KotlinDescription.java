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
 * Language description for Kotlin
 *
 * @author Adapted from JavaScriptDescription
 */
public class KotlinDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            // Kotlin single-character operators
            return (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' ||
                    c == '=' || c == '!' || c == '<' || c == '>' || c == '&' ||
                    c == '|' || c == '^' || c == '?' || c == ':' || c == '.' ||
                    c == ',' || c == ';' || c == '@' || c == '#' || c == '~' ||
                    c == '`' || c == '(' || c == ')' || c == '[' || c == ']' ||
                    c == '{' || c == '}');
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        return a == '/' && b == '/';
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        return a == '/' && b == '*';
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return a == '*' && b == '/';
    }

    @Override
    public String[] getKeywords() {
        return new String[]{
                // Hard keywords
                "as", "as?", "break", "class", "continue", "do", "else", "false",
                "for", "fun", "if", "in", "!in", "is", "!is", "null", "object",
                "package", "return", "super", "this", "throw", "true", "try",
                "typealias", "typeof", "val", "var", "when", "while",

                // Soft keywords and modifiers
                "abstract", "annotation", "by", "catch", "companion", "const",
                "constructor", "crossinline", "data", "dynamic", "enum", "expect",
                "external", "final", "finally", "get", "import", "infix", "inline",
                "inner", "interface", "internal", "lateinit", "noinline", "open",
                "operator", "out", "override", "private", "protected", "public",
                "reified", "sealed", "set", "suspend", "tailrec", "vararg", "where"
        };
    }

    @Override
    public boolean useTab() {
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        switch (operator) {
            case "{":
                return 4;
            case "}":
                return -4;
            default:
                return 0;
        }
    }

    @Override
    public boolean isSupportBlockLine() {
        return true;
    }

    @Override
    public boolean isBlockStart(String operator) {
        return "{".equals(operator);
    }

    @Override
    public boolean isBlockEnd(String operator) {
        return "}".equals(operator);
    }
}