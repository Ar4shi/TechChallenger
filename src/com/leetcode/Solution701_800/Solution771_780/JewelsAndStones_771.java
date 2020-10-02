package com.leetcode.Solution701_800.Solution771_780;

/**
 * 宝石与石头
 *
 * @author jianghan
 * @date 2020-10-02 21:12
 */
public class JewelsAndStones_771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (S.charAt(i) == J.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
