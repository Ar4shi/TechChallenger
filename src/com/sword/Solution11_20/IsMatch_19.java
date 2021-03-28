package com.sword.Solution11_20;

/**
 * 剑指 Offer 19. 正则表达式匹配
 *
 * @author jianghan
 * @date 2021-03-28 15:07
 */
public class IsMatch_19 {
    public boolean isMatch(String s, String p) {

        //这里 长度 + 1 是为了取s和p的前0位
        //如果定义成s.length() 那么只能理解成从索引0的地方取即至少取一位 这样就不对了
        int sLength = s.length() + 1;
        int pLength = p.length() + 1;
        //dp[i][j] 表示 s前i位 和 p前j位的匹配关系
        //dp的索引不能理解为s和p中的索引 而应该理解为s和p取前多少位 所以s和p索引的位置需要多-1
        //例dp[1][x] 此时 应该要拿s.charAt(1-1)来计算
        //dp[i][j] 的状态与前一种状态相关
        boolean dp[][] = new boolean[sLength][pLength];
        //initial dp
        //1、"" 和 "" 可以匹配上
        dp[0][0] = true;
        //2、"" 和 偶数位的"*"【可能】可以匹配上,此时"*" 可以让其之前的字符出现0次
        for (int i = 2; i < pLength; i++) {
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }
        //3、"xxxxx..."  和 "" 无论如何也匹配不上 默认是false所以不用初始化了

        //套dp模板暴力检索
        for (int i = 1; i < sLength; i++) {
            for (int j = 1; j < pLength; j++) {
                if (p.charAt(j - 1) == '*') {
                    //这里同上面的初始化阶段【2】
                    if (dp[i][j - 2]) dp[i][j] = true;
                    //这里说实话贼jb难想 我是抄的 反正我没办法独自想出来这种分类
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true;
                    else if (dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;
                } else {
                    //如果 c2 == '.' || c1 == c2 则前一状态能匹配上 本状态也能匹配上
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;
                    else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;
                }
            }
        }
        return dp[sLength - 1][pLength - 1];
    }

    public static void main(String[] args) {
        IsMatch_19 isMatch_19 = new IsMatch_19();
        isMatch_19.isMatch("aa", "a*");
    }
}
