package io.github.rosemoe.sora.widget.schemes;

import io.github.rosemoe.sora.widget.EditorColorScheme;

/**
 * VS Code Light+ 主题
 * 基于 Visual Studio Code 默认亮色配色方案
 */
public class SchemeVScodeLight extends EditorColorScheme {

    @Override
    public void applyDefault() {
        super.applyDefault();

        // 基础背景与文本
        setColor(WHOLE_BACKGROUND, 0xFFFFFFFF);      // 整体背景 - 纯白
        setColor(TEXT_NORMAL, 0xFF333333);           // 正常文本 - 深灰
        setColor(LINE_NUMBER_BACKGROUND, 0xFFF3F3F3); // 行号背景 - 浅灰
        setColor(LINE_NUMBER, 0xFF237893);            // 行号 - 深蓝灰
        setColor(LINE_DIVIDER, 0xFFE5E5E5);           // 行分隔线 - 淡灰

        // 语法高亮
        setColor(KEYWORD, 0xFF3366cc);                // 关键字 - 柔和蓝（如 public, class）
        setColor(LITERAL, 0xFFA31515);                // 字符串字面量 - 红褐
        setColor(OPERATOR, 0xFF000000);               // 操作符 - 黑色
        setColor(COMMENT, 0xFF008000);                // 注释 - 绿色
        setColor(FUNCTION_NAME, 0xFF795E26);          // 函数名 - 棕色
        setColor(IDENTIFIER_NAME, 0xFF000000);        // 标识符名 - 黑色
        setColor(IDENTIFIER_VAR, 0xFF001080);         // 变量标识符 - 深蓝
        setColor(ANNOTATION, 0xFF3C7E6B);             // 注解 - 蓝绿色

        // 界面元素
        setColor(CURRENT_LINE, 0xFFE5EBF1);           // 当前行高亮 - 淡蓝灰
        setColor(SELECTED_TEXT_BACKGROUND, 0xFFADD6FF); // 选中文本背景 - 淡蓝
        setColor(MATCHED_TEXT_BACKGROUND, 0xFFF0D8B0); // 括号/单词匹配背景 - 米色
        setColor(SELECTION_INSERT, 0xFF000000);       // 插入选择光标颜色 - 黑色
        setColor(SELECTION_HANDLE, 0xFF000000);       // 选择手柄颜色 - 黑色
        setColor(BLOCK_LINE, 0xFFC8C8C8);             // 代码块线 - 浅灰
        setColor(BLOCK_LINE_CURRENT, 0xFF848484);     // 当前块线 - 中灰
        setColor(NON_PRINTABLE_CHAR, 0xFFCCCCCC);     // 非打印字符 - 淡灰

        // 滚动条
        setColor(SCROLL_BAR_THUMB, 0xFFC1C1C1);       // 滚动条滑块 - 浅灰
        setColor(SCROLL_BAR_THUMB_PRESSED, 0xFFA0A0A0); // 按下状态滚动条 - 中灰
    }
}