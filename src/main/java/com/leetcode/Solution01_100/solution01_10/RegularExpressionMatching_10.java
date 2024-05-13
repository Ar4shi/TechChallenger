package com.leetcode.Solution01_100.solution01_10;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * <p>
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * <p>
 * 输出：false
 * <p>
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * <p>
 * 输入：s = "aa", p = "a*"
 * <p>
 * 输出：true
 * <p>
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "ab", p = ".*"
 * <p>
 * 输出：true
 * <p>
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */
public class RegularExpressionMatching_10 {

    public boolean isMatch(String s, String p) {
        return false;
    }
}
