package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;

public class TiecodeDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            return (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' ||
                    c == '=' || c == '>' || c == '<' || c == '!' ||
                    c == '且' || c == '或');
        }
        if (length == 2) {
            char a = characters[0];
            char b = characters[1];
            return (a == '=' && b == '=') ||
                   (a == '!' && b == '=') ||
                   (a == '>' && b == '=') ||
                   (a == '<' && b == '=') ||
                   (a == '&' && b == '&') ||
                   (a == '|' && b == '|');
        }
        if (length == 3) {
            return (characters[0] == '<' && characters[1] == '=' && characters[2] == '>');
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
            "类", "结束", "继承", "为", "常量", "事件", "如果", "假如", "否则", "循环",
            "订阅事件", "方法", "变量", "返回", "定义事件", "code", "本类", "父对象",
            "真", "假", "文本", "整数", "长整数", "逻辑型", "字符", "字节", "小数", 
            "文本框", "编辑框", "按钮", "多选框", "单选框", "开关", "图片框", "圆形图片框", "进度圈", "进度条", "拖动条", "评分条", "视频播放器", "浏览框", "GIF动画框", "圆形进度条", "列表框", "自定义列表框", "下拉列表框", "自定义下拉列表框", "宫格列表框", "自定义宫格列表框", 
            "单精度小数", "对象", "变体型", "异常"
        };
    }

    @Override
    public boolean useTab() {
        return true;
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