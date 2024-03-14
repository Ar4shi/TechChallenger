package com.leetcode.Solution901_1000.Solution971_980;

import java.util.Arrays;

/**
 * 最接近原点的 K 个点
 *
 * @author jianghan
 * @date 2020-11-09 00:45
 */
public class KClosestPointsToOrigin_973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        int[] distance = new int[points.length];
        int[] distanceCopy = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            distance[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            distanceCopy[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        Arrays.sort(distance);
        for (int i = 0; i < K; i++) {
            int currentDistance = distance[i];
            for (int j = 0; j < points.length; j++) {
                if (distanceCopy[j] == currentDistance) {
                    distanceCopy[j] = Integer.MAX_VALUE;
                    result[i][0] = points[j][0];
                    result[i][1] = points[j][1];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin_973 kClosestPointsToOrigin_973 = new KClosestPointsToOrigin_973();
        kClosestPointsToOrigin_973.kClosest(new int[][]{{0, 1}, {1, 0}},2);
    }
}
