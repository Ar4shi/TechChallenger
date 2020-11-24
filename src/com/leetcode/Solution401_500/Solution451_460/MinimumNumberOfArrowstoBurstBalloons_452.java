package com.leetcode.Solution401_500.Solution451_460;

import java.util.Arrays;

/**
 * 用最少数量的箭引爆气球
 *
 * @author jianghan
 * @date 2020-11-23 00:05
 */
public class MinimumNumberOfArrowstoBurstBalloons_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (p1, p2) -> p1[0] < p2[0] ? -1 : 1);
        int start = points[0][0], end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] <= end) {
                start = Math.max(points[i][0], start);
                end = Math.min(points[i][1], end);
            } else {
                count++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        return count;
    }
}
