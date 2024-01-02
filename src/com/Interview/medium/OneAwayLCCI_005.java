package com.Interview.medium;

/**
 * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class OneAwayLCCI_005 {

    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return checkReplace(first, second);
        } else {
            return checkAddOrDelete(first, second);
        }
    }

    private boolean checkReplace(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            Character c1 = first.charAt(i);
            Character c2 = second.charAt(i);
            if (!c1.equals(c2)) {
                count += 1;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkAddOrDelete(String first, String second) {
        String longStr = first.length() > second.length() ? first : second;
        String shortStr = first.length() > second.length() ? second : first;
        if (longStr.length() - shortStr.length() != 1) {
            return false;
        }
        int longIndex = 0;
        for (int shortIndex = 0; shortIndex < shortStr.length(); shortIndex++) {
            if (longStr.charAt(longIndex) != shortStr.charAt(shortIndex)) {
                shortIndex--;
            }
            if (longIndex - shortIndex > 1) {
                return false;
            }
            longIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        OneAwayLCCI_005 oneAwayLCCI_005 = new OneAwayLCCI_005();
        System.out.println(oneAwayLCCI_005.oneEditAway("teacher","bleacher"));
    }
}
