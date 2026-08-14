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
 * Language description for Smali (Dalvik bytecode)
 *
 * @author Adapted from JavaScriptDescription
 */
public class SmaliDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            // Smali operators (exclude '.' and ':' which are part of identifiers)
            return (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' ||
                    c == '=' || c == '<' || c == '>' || c == '!' || c == '&' ||
                    c == '|' || c == '^' || c == '~' || c == '?' || c == ',' ||
                    c == ';' || c == '(' || c == ')' || c == '[' || c == ']' ||
                    c == '{' || c == '}' || c == '@' || c == '#');
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        // Smali uses '#' for single-line comments
        return a == '#';
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        // Smali does not have block comments
        return false;
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return false;
    }

    @Override
    public String[] getKeywords() {
        return new String[]{
                // Directives
                ".method", ".end", ".field", ".annotation", ".end", ".param", ".line",
                ".local", ".prologue", ".epilogue", ".catch", ".catchall", ".array-data",
                ".end", ".packed-switch", ".sparse-switch", ".fill-array-data", ".registers",
                ".locals", ".restart", ".enclosing", ".inner", ".source", ".debug", ".class",
                ".super", ".implements", ".subannotation",
                // Access modifiers
                "public", "private", "protected", "static", "final", "synchronized",
                "volatile", "transient", "native", "abstract", "strictfp", "synthetic",
                "deprecated", "bridge", "varargs", "enum", "annotation",
                // Data types (descriptor forms)
                "void", "boolean", "byte", "char", "short", "int", "long", "float", "double",
                // Common opcodes
                "move", "move-result", "move-exception", "return", "return-void", "return-object",
                "const", "const-string", "const-class", "monitor-enter", "monitor-exit",
                "check-cast", "instance-of", "new-instance", "new-array", "filled-new-array",
                "array-length", "throw", "goto", "pack-switch", "sparse-switch",
                "if-eq", "if-ne", "if-lt", "if-ge", "if-gt", "if-le",
                "if-eqz", "if-nez", "if-ltz", "if-gez", "if-gtz", "if-lez",
                "invoke-direct", "invoke-virtual", "invoke-static", "invoke-interface",
                "invoke-super", "invoke-direct/range", "invoke-virtual/range",
                "invoke-static/range", "invoke-interface/range", "invoke-super/range",
                "filled-new-array/range"
        };
    }

    @Override
    public boolean useTab() {
        // Use spaces for indentation
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        // Smali does not use braces for block scoping, no special indentation adjustment needed
        return 0;
    }

    @Override
    public boolean isSupportBlockLine() {
        return true;
    }

    @Override
    public boolean isBlockStart(String operator) {
        // No block start operators in Smali (no '{')
        return false;
    }

    @Override
    public boolean isBlockEnd(String operator) {
        // No block end operators in Smali (no '}')
        return false;
    }
}