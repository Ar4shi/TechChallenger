package com.leetcode.Solution1201_1300.Solution1211_1220;

/**
 * 统计元音字母序列的数目
 *
 * @author jianghan
 * @date 2022-01-18 02:44
 */
public class CountVowelsPermutation_1220 {
    public int countVowelPermutation(int n) {

        long div = 1000000007;

        // dp[1][0] = 当n = 1 时 末位是 a 的个数 ， 以此类推
        long[][] dp = new long[n + 1][5];
        // 初始化
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;

        if (n == 1) {
            return 5;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % div;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % div;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % div;
            // 这里没有进行运算 所以不要取模了
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % div;
        }
        return (int) ((dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4]) % div);
    }

    public static void main(String[] args) {
        CountVowelsPermutation_1220 countVowelsPermutation_1220 = new CountVowelsPermutation_1220();
        System.out.println(countVowelsPermutation_1220.countVowelPermutation(144));
    }
}
