package com.leetcode.solution21_30;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author jianghanh
 * @date 2019-06-27 19:03
 */
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        backtrack(resultList,"",0,0,n);
        return resultList;
    }

    /**
     * 回溯法： 判断条件 1、当前字符串左括号数量小于n  2、当前字符串右括号数量小于左括号数量
     */
    private void backtrack(List<String> resultList, String currentStr, int leftCount, int rightCount,int max) {
        if(currentStr.length()==2*max){//回溯函数出口
            resultList.add(currentStr);
            return;
        }
        if(leftCount<max){
            backtrack(resultList,currentStr+"(",leftCount+1,rightCount,max);//如果左括号<总数量 则可以增加左括号
        }
        if(rightCount<leftCount){
            backtrack(resultList,currentStr+")",leftCount,rightCount+1,max);//如果右括号<左括号 则可以增加右括号
        }
    }
}
