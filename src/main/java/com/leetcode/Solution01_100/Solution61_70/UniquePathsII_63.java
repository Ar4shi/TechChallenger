package com.leetcode.Solution01_100.Solution61_70;

/**
 * 不同路径 II
 *
 * @author jianghan
 * @date 2020-09-19 15:49
 */
public class UniquePathsII_63 {
    int[][] dp;
    int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        if (obstacleGrid.length == 1) {
            for (int i = 0; i < obstacleGrid[0].length; i++) {
                if (obstacleGrid[0][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if (obstacleGrid[0].length == 1) {
            for (int i = 0; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i][0] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //初始化
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                if (i > 0 && dp[0][i - 1] == 0) {
                    dp[0][i] = 0;
                    continue;
                }
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                if (i > 0 && dp[i - 1][0] == 0) {
                    dp[i][0] = 0;
                    continue;
                }
                dp[i][0] = 1;
            }
        }
        dp(m, n);
        return dp[m - 1][n - 1];
    }

    private void dp(int m, int n) {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] != 1) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }
                if (obstacleGrid[i][j - 1] != 1 && obstacleGrid[i - 1][j] == 1) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        UniquePathsII_63 uniquePathsII_63 = new UniquePathsII_63();
        uniquePathsII_63.uniquePathsWithObstacles(new int[][]{
                {1, 0}, {0, 0}
        });
    }
}
