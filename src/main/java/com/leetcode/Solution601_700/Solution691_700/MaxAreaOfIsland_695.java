package com.leetcode.Solution601_700.Solution691_700;

/**
 * 岛屿的最大面积
 *
 * @author jianghan
 * @date 2020-03-15 01:08
 */
public class MaxAreaOfIsland_695 {
    int[][] grid;
    int res = 0;

    public int maxAreaOfIsland(int[][] grid) {
        /*存储已经遍历过的数字的坐标*/
        int[][] dp = new int[grid.length][grid[0].length];
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dp[i][j] != 1) {
                    int temp = DFS(i, j, 0, dp);
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    /**
     * 深度优先
     * x:横坐标 y:纵坐标 length:目前长度 dp:将已遍历过的坐标记录为1此后不再遍历
     */
    private int DFS(int x, int y, int length, int[][] dp) {
        if (grid[x][y] == 1) {
            dp[x][y] = 1;
            length += 1;
            /*试探上节点*/
            if (x - 1 >= 0 && grid[x - 1][y] == 1 && dp[x - 1][y] != 1) {
                dp[x - 1][y] = 1;
                length = DFS(x - 1, y, length, dp);
            }
            /*试探下节点*/
            if (x + 1 < grid.length && grid[x + 1][y] == 1 && dp[x + 1][y] != 1) {
                dp[x + 1][y] = 1;
                length = DFS(x + 1, y, length, dp);
            }
            /*试探左节点*/
            if (y - 1 >= 0 && grid[x][y - 1] == 1 && dp[x][y - 1] != 1) {
                dp[x][y - 1] = 1;
                length = DFS(x, y - 1, length, dp);
            }
            /*试探右节点*/
            if (y + 1 < grid[x].length && grid[x][y + 1] == 1 && dp[x][y + 1] != 1) {
                dp[x][y + 1] = 1;
                length = DFS(x, y + 1, length, dp);
            }
        }
        return length;
    }
}
