package com.leetcode.Solution331_340;

/**
 * 请输入类注释
 *
 * @author jianghanh
 * @date 2020-03-08 02:20
 */
public class CoinChange_322 {
    int res = -1;
    public int coinChange(int[] coins, int amount) {
        DFS(coins, amount, 0);
        return res;
    }

    /**
     * 深度优先算法
     * 剪枝+回溯
     * 递归方式
     * 此方法时间复杂度过高 超时！！！
     */
    private void DFS(int[] coins, int amount, int rank) {
        rank = rank+1;
        if (amount == 0) {
            if (res > 0) {
                res = Math.min(res, rank-1);
            } else {
                res = rank-1;
            }
            return;
        }
        if (amount > 0){
            for (int i = 0; i < coins.length; i++) {
                DFS(coins, amount - coins[i], rank);
            }
        }
    }

    public static void main(String[] args) {
        CoinChange_322 coinChange_322 = new CoinChange_322();
        System.out.println(coinChange_322.coinChange(new int[]{1,2,5},11));
    }
}
