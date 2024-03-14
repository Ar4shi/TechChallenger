package com.leetcode.Solution1101_1200.Solution1121_1130;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 距离顺序排列矩阵单元格
 *
 * @author jianghan
 * @date 2020-11-17 00:17
 */
public class MatrixCellsInDistanceOrder_1130 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int distance = Math.abs(i - r0) + Math.abs(j - c0);
                int[] location = new int[]{distance, i, j};
                list.add(location);
            }
        }
        Collections.sort(list, (l1, l2) -> l1[0] - l2[0]);
        List<int[]> result = new LinkedList<>();
        for (int[] l : list) {
            result.add(new int[]{l[1], l[2]});
        }
        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        MatrixCellsInDistanceOrder_1130 matrixCellsInDistanceOrder_1130 = new MatrixCellsInDistanceOrder_1130();
        matrixCellsInDistanceOrder_1130.allCellsDistOrder(3, 5, 2, 3);
    }
}
