package com.leetcode.Solution801_900.Solution831_840;

/**
 * 矩形重叠
 *
 * @author jianghan
 * @date 2020-03-18 01:14
 */
public class RectangleOverlap_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[3]<=rec2[1]||rec2[3]<=rec1[1]||rec2[2]<=rec1[0]||rec1[2]<=rec2[0]);
    }
}
