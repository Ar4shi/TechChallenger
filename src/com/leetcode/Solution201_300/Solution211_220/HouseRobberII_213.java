package com.leetcode.Solution201_300.Solution211_220;

/**
 * 打家劫舍 II
 *
 * @author jianghan
 * @date 2021-01-27 00:35
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //dp[i][j][k]代表偷窃到第i间房屋且偷窃状态为j且第一间屋子偷窃状态为k所能获得的最大利润
        int[][][] dp = new int[nums.length][2][2];
        //初始化 其实第一间屋子的状态无关紧要
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = nums[0];
        //套模板 第二间屋子和最后一间屋子单独讨论
        dp[1][0][0] = 0;
        dp[1][0][1] = nums[0];
        dp[1][1][0] = nums[1];
        dp[1][1][1] = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length - 1; i++) {
            //当前屋子不偷 前一间屋子可以偷也可以不偷
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1]);
            //当前屋子偷 前一间屋子必定不偷
            dp[i][1][0] = dp[i - 1][0][0] + nums[i];
            dp[i][1][1] = dp[i - 1][0][1] + nums[i];
        }
        //最后一间屋子
        dp[nums.length - 1][0][0] = Math.max(dp[nums.length - 2][0][0], dp[nums.length - 2][1][0]);
        dp[nums.length - 1][0][1] = Math.max(dp[nums.length - 2][0][1], dp[nums.length - 2][1][1]);
        dp[nums.length - 1][1][0] = dp[nums.length - 2][0][0] + nums[nums.length - 1];
        dp[nums.length - 1][1][1] = Integer.MIN_VALUE;
        return Math.max(Math.max(dp[nums.length - 1][0][0], dp[nums.length - 1][0][1]), Math.max(dp[nums.length - 1][0][0], dp[nums.length - 1][1][0]));
    }

    public static void main(String[] args) {
        HouseRobberII_213 houseRobberII_213 = new HouseRobberII_213();
        houseRobberII_213.rob(new int[]{200, 3, 140, 20, 10});
    }
}
