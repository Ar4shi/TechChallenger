package com.leetcode.Solution101_200.Solution111_120;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author jianghan
 * @date 2020-09-20 14:21
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(dp.get(i - 1).get(j) + triangle.get(i).get(j));
                    dp.add(list);
                } else if (j == triangle.get(i).size() - 1) {
                    dp.get(i).add(dp.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else {
                    dp.get(i).add(Math.min(dp.get(i - 1).get(j), dp.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(dp.size() - 1).size(); i++) {
            minSum = Math.min(dp.get(dp.size() - 1).get(i), minSum);
        }
        return minSum;
    }
}
