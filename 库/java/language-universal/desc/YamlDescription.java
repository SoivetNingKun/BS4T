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
 * Language description for YAML
 *
 * @author DeepSeek
 */
public class YamlDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            // YAML indicators: : - ? ! | > [ ] { } , & * @
            return (c == ':' || c == '-' || c == '?' || c == '!' ||
                    c == '|' || c == '>' || c == '[' || c == ']' ||
                    c == '{' || c == '}' || c == ',' || c == '&' ||
                    c == '*' || c == '@');
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        // YAML comments start with '#'
        return a == '#';
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        // YAML has no block comments
        return false;
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        // YAML has no block comments
        return false;
    }

    @Override
    public String[] getKeywords() {
        // YAML reserved words / constants
        return new String[]{
                "true", "false", "yes", "no", "on", "off",
                "null", "~", "y", "n"
        };
    }

    @Override
    public boolean useTab() {
        // YAML uses spaces (usually 2) for indentation
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        // Indentation increase after ':' (map key) or '-' (list item)
        // Return positive value to increase indent in next line
        switch (operator) {
            case ":":
                return 2;   // Typical YAML indentation step
            case "-":
                return 2;
        }
        return 0;
    }

    @Override
    public boolean isSupportBlockLine() {
        // YAML supports block structure (via indentation or flow syntax)
        return true;
    }

    @Override
    public boolean isBlockStart(String operator) {
        // Flow mapping or sequence start
        return operator.equals("{") || operator.equals("[");
    }

    @Override
    public boolean isBlockEnd(String operator) {
        // Flow mapping or sequence end
        return operator.equals("}") || operator.equals("]");
    }
}