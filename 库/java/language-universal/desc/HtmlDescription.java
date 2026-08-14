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
 * Language description for HTML
 *
 * @author Rose
 */
public class HtmlDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            // HTML operators: angle brackets, slash, equals, colon, hyphen, underscore, question mark, exclamation
            return (c == '<' || c == '>' || c == '/' || c == '=' || c == ':' ||
                    c == '-' || c == '_' || c == '?' || c == '!');
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        // HTML does not have line comments
        return false;
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        // HTML comment starts with "<!--" but only two chars are checked here.
        // We use "<!" as the start marker; the full check is handled by the lexer.
        return a == '<' && b == '!';
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        // HTML comment ends with "-->" -> first two chars are '-', '-'
        return a == '-' && b == '-';
    }

    @Override
    public String[] getKeywords() {
        // Common HTML tags and attributes
        return new String[]{
                "html", "head", "body", "title", "meta", "link", "style", "script",
                "div", "span", "p", "h1", "h2", "h3", "h4", "h5", "h6",
                "ul", "ol", "li", "a", "img", "table", "tr", "td", "th",
                "form", "input", "button", "label", "select", "option",
                "br", "hr", "strong", "em", "b", "i", "u", "pre", "code",
                "class", "id", "src", "href", "alt", "type", "value", "name"
        };
    }

    @Override
    public boolean useTab() {
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        // Indentation for block-like structures: increase after '<', decrease after '>'
        switch (operator) {
            case "<":
                return 4;
            case ">":
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
        // Treat '<' as block start (opening tag)
        return operator.equals("<");
    }

    @Override
    public boolean isBlockEnd(String operator) {
        // Treat '>' as block end (closing tag)
        return operator.equals(">");
    }
}