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
 * COBOL language description for syntax highlighting.
 * 
 * @author Rose (modified for COBOL)
 */
public class COBOLdescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            // COBOL common operators: arithmetic, relational, punctuation
            return (c == '+' || c == '-' || c == '*' || c == '/' || c == '=' ||
                    c == '<' || c == '>' || c == '.' || c == ',' || c == ';' ||
                    c == '(' || c == ')' || c == ':' || c == '&' || c == '|' ||
                    c == '!' || c == '%' || c == '^' || c == '~' || c == '?' ||
                    c == '[' || c == ']' || c == '{' || c == '}');
        } else if (length == 2) {
            char a = characters[0];
            char b = characters[1];
            // Multi-character operators: exponentiation, relational
            return (a == '*' && b == '*') ||  // **
                    (a == '<' && b == '=') || // <=
                    (a == '>' && b == '=') || // >=
                    (a == '<' && b == '>') || // <>
                    (a == '=' && b == '=');   // == (not standard, but keep)
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        // COBOL commonly uses *> for inline comments, also support // for convenience
        return (a == '*' && b == '>') || (a == '/' && b == '/');
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        // COBOL does not have block comments
        return false;
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return false;
    }

    @Override
    public String[] getKeywords() {
        // Comprehensive list of COBOL reserved words (case-insensitive, but provided in uppercase)
        return new String[]{
                "IDENTIFICATION", "DIVISION", "DATA", "WORKING-STORAGE", "LINKAGE",
                "PROCEDURE", "DECLARATIVES", "END", "PROGRAM", "SUBPROGRAM", "FUNCTION",
                "MOVE", "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "COMPUTE", "PERFORM",
                "IF", "ELSE", "END-IF", "EVALUATE", "WHEN", "END-EVALUATE", "CALL",
                "USING", "GIVING", "RETURN", "STOP", "RUN", "DISPLAY", "ACCEPT",
                "OPEN", "CLOSE", "READ", "WRITE", "REWRITE", "DELETE", "START",
                "INSPECT", "STRING", "UNSTRING", "SORT", "MERGE", "REPLACE",
                "COPY", "INITIALIZE", "SET", "SEARCH", "ALL", "SOME", "ANY",
                "THRU", "THROUGH", "BY", "TO", "FROM", "UNTIL", "VARYING",
                "WHILE", "CONTINUE", "EXIT", "GO", "BACK", "CANCEL", "GOBACK",
                "INITIAL", "COMMON", "RECURSIVE", "RAISE", "EXCEPTION", "RESUME",
                "AT", "END-READ", "END-WRITE", "END-PERFORM", "END-IF", "END-EVALUATE",
                "DEPENDING", "ON", "OFF", "TRUE", "FALSE", "ZERO", "ZEROS", "SPACE",
                "SPACES", "LOW-VALUES", "HIGH-VALUES", "NULL", "NULLS",
                "AREA", "BLANK", "JUST", "JUSTIFIED", "SIGN", "LEADING", "TRAILING",
                "SEPARATE", "OCCURS", "INDEXED", "SEQUENTIAL", "RELATIVE",
                "DYNAMIC", "ACCESS", "RECORD", "KEY", "LOCK", "MODE", "STATUS",
                "CONTROL", "LENGTH", "SIZE", "TALLY", "COUNT"
        };
    }

    @Override
    public boolean useTab() {
        // COBOL typically uses spaces for indentation
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        // No operator-based indentation in COBOL
        return 0;
    }

    @Override
    public boolean isSupportBlockLine() {
        // Enable block line visualization if needed
        return true;
    }

    @Override
    public boolean isBlockStart(String operator) {
        // COBOL uses keywords (e.g., IF, PERFORM) for blocks, not operators
        return false;
    }

    @Override
    public boolean isBlockEnd(String operator) {
        return false;
    }
}