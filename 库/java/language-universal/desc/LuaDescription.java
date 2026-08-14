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
 * Language description for Lua
 * 
 * @author Rose
 */
public class LuaDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            return (c == '+' || c == '-' || c == '{' || c == '}' || c == '[' || c == ']' ||
                    c == '(' || c == ')' || c == '|' || c == ':' || c == '.' || c == ',' ||
                    c == ';' || c == '*' || c == '/' || c == '&' || c == '^' || c == '%' ||
                    c == '#' || c == '~' || c == '<' || c == '>' || c == '=');
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        return a == '-' && b == '-';
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        // Lua block comments start with --[[, which cannot be detected with only two characters.
        // Return false to disable block comment support.
        return false;
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        // Lua block comments end with ]], also requires two characters but can't be properly matched without context.
        return false;
    }

    @Override
    public String[] getKeywords() {
        return new String[]{
                "and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto",
                "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while"
        };
    }

    @Override
    public boolean useTab() {
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        // Lua uses 'do', 'then', 'function', etc. for blocks, but those are keywords.
        // For table constructors using '{' and '}', provide indentation similar to JavaScript.
        switch (operator) {
            case "{":
                return 4;
            case "}":
                return -4;
        }
        return 0;
    }

    @Override
    public boolean isSupportBlockLine() {
        return true;
    }

    @Override
    public boolean isBlockStart(String operator) {
        // Use '{' as block start for Lua tables (common folding point)
        return operator.equals("{");
    }

    @Override
    public boolean isBlockEnd(String operator) {
        // Use '}' as block end
        return operator.equals("}");
    }

}