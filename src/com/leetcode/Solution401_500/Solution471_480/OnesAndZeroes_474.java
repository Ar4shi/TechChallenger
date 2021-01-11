package com.leetcode.Solution401_500.Solution471_480;

/**
 * 一和零
 *
 * @author jianghan
 * @date 2021-01-12 02:05
 */
public class OnesAndZeroes_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j][k]表示 只使用前[i]个字符串,容量为j个0,k个1 最大子集的个数
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        //从1开始就可以了,因为选0个字符串肯定是0 ↑初始化dp的时候已经全是0了
        for (int i = 1; i < strs.length + 1; i++) {
            //此时注意到i  和jk 其实在含以上有本质的差距
            //strCount容量为2 strCount[0]代表strs[i]中0的数量 strCount[1]同理
            int[] strCount = this.countZeroAndOne(strs[i - 1]);
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    //如果 0 的数量或者1的数量中的任意一个比背包的容量大,则肯定不能选取当前的字符串
                    if (strCount[0] > j || strCount[1] > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        //选这个字符串或者不选这个字符串取最大值
                        dp[i][j][k] = Math.max(dp[i - 1][j - strCount[0]][k - strCount[1]] + 1, dp[i - 1][j][k]);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    /**
     * 计算字符串中0,1的数量
     */
    private int[] countZeroAndOne(String str) {
        int[] res = new int[2];
        if (str == null) {
            return res;
        }
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        res[0] = count0;
        res[1] = count1;
        return res;
    }

    public static void main(String[] args) {
        OnesAndZeroes_474 onesAndZeroes_474 = new OnesAndZeroes_474();
        onesAndZeroes_474.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
    }
}
