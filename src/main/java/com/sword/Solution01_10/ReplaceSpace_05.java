package com.sword.Solution01_10;

/**
 * 剑指 Offer 05. 替换空格
 *
 * @author jianghan
 * @date 2021-03-20 14:38
 */
public class ReplaceSpace_05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
