package com.leetcode.Solution1301_1400.Solution1361_1370;

/**
 * 上升下降字符串
 *
 * @author jianghan
 * @date 2020-11-25 00:33
 */
public class IncreasingDecreasingString_1370 {

    //桶计数
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            count[s.charAt(i) - 'a'] += 1;
        }
        while (length > 0) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    count[i] -= 1;
                    sb.append((char) (i + 'a'));
                    length--;
                }
            }
            for (int j = 25; j >= 0; j--) {
                if (count[j] > 0) {
                    count[j] -= 1;
                    sb.append((char) (j + 'a'));
                    length--;
                }
            }
        }
        return sb.toString();
    }
}
