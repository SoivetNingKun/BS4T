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
 * Language description for Assembly (x86/x64, NASM style)
 * 
 * @author Adapted from Rose's JavaScriptDescription
 */
public class AssemblyDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            // Common assembly operators: arithmetic, brackets, comma, colon, etc.
            return (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' ||
                    c == '[' || c == ']' || c == '(' || c == ')' || c == ',' ||
                    c == ':' || c == ';' || c == '&' || c == '|' || c == '^' ||
                    c == '~' || c == '!' || c == '<' || c == '>' || c == '=');
        }
        // Multi-character operators (e.g., <<, >>) are not typical in basic assembly
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        // Assembly often uses ';' for line comments, also support C++ style '//'
        return a == ';' || (a == '/' && b == '/');
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        // Support C-style multi-line comments for compatibility
        return a == '/' && b == '*';
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return a == '*' && b == '/';
    }

    @Override
    public String[] getKeywords() {
        // Common x86/x64 instruction mnemonics, registers, and pseudo-instructions
        return new String[]{
            // Data movement
            "mov", "push", "pop", "lea", "xchg", "movzx", "movsx",
            // Arithmetic
            "add", "sub", "mul", "div", "inc", "dec", "neg", "adc", "sbb",
            // Bitwise
            "and", "or", "xor", "not", "shl", "shr", "sal", "sar", "rol", "ror",
            // Control transfer
            "jmp", "call", "ret", "iret", "int", "into", "iret", "syscall",
            "je", "jz", "jne", "jnz", "jg", "jnle", "jge", "jnl", "jl", "jnge",
            "jle", "jng", "ja", "jnbe", "jae", "jnb", "jb", "jnae", "jbe", "jna",
            "jc", "jnc", "jo", "jno", "js", "jns", "jcxz", "jecxz",
            // Stack and procedure
            "enter", "leave", "pushf", "popf", "pusha", "popa",
            // Flags and special
            "cmp", "test", "nop", "hlt", "lock", "wait", "cpuid",
            // Pseudo-instructions / directives
            "db", "dw", "dd", "dq", "dt", "align", "section", "segment",
            "global", "extern", "proc", "endp", "macro", "endm", "equ", "times",
            // Registers (general purpose)
            "al", "ah", "ax", "eax", "rax",
            "bl", "bh", "bx", "ebx", "rbx",
            "cl", "ch", "cx", "ecx", "rcx",
            "dl", "dh", "dx", "edx", "rdx",
            "si", "esi", "rsi", "di", "edi", "rdi",
            "bp", "ebp", "rbp", "sp", "esp", "rsp",
            "r8", "r9", "r10", "r11", "r12", "r13", "r14", "r15",
            "r8b", "r9b", "r10b", "r11b", "r12b", "r13b", "r14b", "r15b",
            "r8w", "r9w", "r10w", "r11w", "r12w", "r13w", "r14w", "r15w",
            "r8d", "r9d", "r10d", "r11d", "r12d", "r13d", "r14d", "r15d",
            // Segment registers
            "cs", "ds", "ss", "es", "fs", "gs"
        };
    }

    @Override
    public boolean useTab() {
        // Prefer spaces for alignment (common in assembly code)
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        // Assembly does not typically auto-indent based on operators
        // You can optionally add indentation for labels or directives if needed
        return 0;
    }

    @Override
    public boolean isSupportBlockLine() {
        // Assembly is not a block-structured language (no { } blocks)
        return false;
    }

    @Override
    public boolean isBlockStart(String operator) {
        // No block start operators in plain assembly
        return false;
    }

    @Override
    public boolean isBlockEnd(String operator) {
        // No block end operators in plain assembly
        return false;
    }
}