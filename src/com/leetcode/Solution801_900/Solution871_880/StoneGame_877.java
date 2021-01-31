package com.leetcode.Solution801_900.Solution871_880;

/**
 * 石子游戏
 *
 * @author jianghan
 * @date 2021-01-29 01:24
 */
public class StoneGame_877 {
    public boolean stoneGame(int[] piles) {
        //dp[a][b][c] 为 在区间[a,b]中 先后手状态为c所能获得的最高分数
        //c的状态 0为先手 1为后手
        int[][][] dp = new int[piles.length][piles.length][2];
        //dp[i][j][0] = max(dp[i+1][j][1]+ piles[i],dp[i][j-1][1]+ piles[j])
        //通过上面的状态转移方程可见 如果我们按层次遍历数组的时候
        //在计算dp[i][j][0]时需要知道dp[i+1][j][1]的值,而此时我们还没算出来dp[i+1][j][1]的值
        //所以需要初始化对角线,斜着遍历
        for (int i = 0; i < piles.length; i++) {
            dp[i][i][0] = piles[i];
        }
        //套模板 斜着遍历数组
        //思路 双重循环 第一层循环控制遍历个数 第二层循环控制遍历起点
        //循环体内部计算必要的坐标点
        for (int i = 1; i < piles.length; i++) {
            for (int j = 0; j < piles.length - i; j++) {
                int x = j;
                int y = i + j;
                //先手的永远有资格拿最优解,所以left和right是在后手的基础上进行计算的
                int left = dp[x + 1][y][1] + piles[x];
                int right = dp[x][y - 1][1] + piles[y];
                if (left >= right) {
                    dp[x][y][0] = left;
                    //由于先拿和后拿都是要取最优解,所以无论先手和后手计算的逻辑和其0、1状态并没有关系
                    //这也是可以往二维甚至一维进行空间优化的关键点
                    dp[x][y][1] = dp[x + 1][y][0];
                } else {
                    dp[x][y][0] = right;
                    dp[x][y][1] = dp[x][y - 1][0];
                }
            }
        }
        return dp[piles.length - 1][piles.length - 1][0] > dp[piles.length - 1][piles.length - 1][1];
    }
}
