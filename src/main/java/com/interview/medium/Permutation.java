package com.interview.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>
 * 示例1:
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * <p>
 * 示例2:
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * <p>
 * 提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class Permutation {

    private List<String> resultList = new ArrayList<>();

    private int[] visited;

    private String S;

    public String[] permutation(String S) {
        visited = new int[S.length()];
        this.S = S;
        dfs("", 0);
        return resultList.toArray(new String[0]);
    }

    private void dfs(String str, int times) {
        if (times == S.length()) {
            resultList.add(str);
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if(visited[i] == 1){
                continue;
            }
            str += S.charAt(i);
            visited[i] = 1;
            dfs(str, times + 1);
            // 还原
            str = str.substring(0, str.length() - 1);
            visited[i] = 0;
        }
    }
}
