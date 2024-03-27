package com.interview.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Bracket {

    // 计数器 0索引代表左括号,1索引代表右括号
    private int[] counter;

    private int n;

    private List<String> result;

    public List<String> generateParenthesis(int n) {
        counter = new int[2];
        this.n = n;
        result = new ArrayList<>();
        dfs("");
        return result;
    }

    private void dfs(String str) {
        if(counter[0] > n || counter[1] > n){
            return;
        }
        if(counter[0] < counter[1]){
            return;
        }
        if (counter[0] == n && counter[1] == n) {
            result.add(str);
            return;
        }
        if(counter[0] > counter[1]){
            str += "(";
            counter[0]++;
            dfs(str);
            str = str.substring(0, str.length() - 1);
            counter[0]--;
            str += ")";
            counter[1]++;
            dfs(str);
            counter[1]--;
        }
        if(counter[0] == counter[1]){
            str += "(";
            counter[0]++;
            dfs(str);
            counter[0]--;
        }
    }
}
