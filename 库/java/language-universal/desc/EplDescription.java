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
 * 易语言语法高亮描述类
 * 支持关键字高亮、行注释（单引号）、运算符识别
 *
 * @author Adapted from JavaScriptDescription
 */
public class EplDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            // 易语言常用运算符（英文符号）
            return (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' ||
                    c == '=' || c == '<' || c == '>' || c == '!' || c == '&' ||
                    c == '|' || c == '^' || c == '~' || c == '.' || c == ',' ||
                    c == ';' || c == ':' || c == '(' || c == ')' || c == '[' ||
                    c == ']' || c == '{' || c == '}' || c == '?');
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        // 易语言行注释以单引号 ' 开头
        return a == '\'';
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        // 易语言通常不支持块注释，返回 false
        return false;
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return false;
    }

    @Override
    public String[] getKeywords() {
        // 易语言常用关键字（中文及少数英文）
        return new String[]{
                // 流程控制
                "如果", "否则", "如果真", "判断", "分支", "默认", "循环", "计次循环首", "变量循环首",
                "判断循环首", "循环判断首", "到循环尾", "跳出循环", "返回", "结束", "退出",
                // 子程序相关
                "子程序", "参数", "局部变量", "全局变量", "程序集变量", "常量", "数据类型",
                // 类与模块
                "类", "方法", "属性", "事件", "接口", "继承", "公开", "私有", "保护",
                // 其他语句
                "如果结束", "判断结束", "循环结束", "计次循环尾", "变量循环尾", "判断循环尾", "循环判断尾",
                "进入", "退出", "尝试", "捕获", "最后", "抛出",
                // 常用命令
                "信息框", "调试输出", "到文本", "到整数", "到数值", "取文本长度", "取数组下标",
                "载入", "销毁", "置焦点", "取焦点", "延迟", "取随机数", "置随机数种子",
                // 常量值
                "真", "假", "空对象", "未定义"
        };
    }

    @Override
    public boolean useTab() {
        // 使用空格缩进
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        return 0;
    }

    @Override
    public boolean isSupportBlockLine() {
        return true;
    }

    @Override
    public boolean isBlockStart(String operator) {
        return false;
    }

    @Override
    public boolean isBlockEnd(String operator) {
        return false;
    }
}