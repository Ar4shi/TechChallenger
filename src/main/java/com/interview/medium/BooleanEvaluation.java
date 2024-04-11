package com.interview.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * <p>
 * 示例 1:
 * 输入: s = "1^0|0|1", result = 0
 * <p>
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * <p>
 * 示例 2:
 * 输入: s = "0&0&0&1^1|0", result = 1
 * 输出: 10
 * <p>
 * 提示：
 * 运算符的数量不超过 19 个
 */
public class BooleanEvaluation {

    int count = 0;
    int result;
    Map<String, String> map = new HashMap<String, String>() {{
        put("1^0", "1");
        put("0^1", "1");
        put("1^1", "0");
        put("0^0", "0");

        put("1&0", "0");
        put("0&1", "0");
        put("1&1", "1");
        put("0&0", "0");

        put("1|0", "1");
        put("0|1", "1");
        put("1|1", "1");
        put("0|0", "0");
    }};

    /**
     * 这个题没做完
     * 下面的算法会重复计算括号的组合，可以使用记忆化搜索优化
     */
    public int countEval(String s, int result) {
        this.result = result;
        dfs(s, s.chars().filter(c -> c == '0').count() + s.chars().filter(c -> c == '1').count());
        return count;
    }

    private void dfs(String s, long numsCount) {
        if (s.length() == 1) {
            if (Integer.parseInt(s) == result) {
                count++;
            }
            return;
        }
        for (int i = 0; i < numsCount - 1; i++) {
            int start = 2 * i;
            String substring = s.substring(start, start + 3);
            String localResult = map.get(substring);
            String newString = s.substring(0, start) + localResult + s.substring(start + 3);
            dfs(newString, numsCount - 1);
        }
    }
}
