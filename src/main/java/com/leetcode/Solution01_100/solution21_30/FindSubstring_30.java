package com.leetcode.Solution01_100.solution21_30;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 串联所有单词的子串
 *
 * @author jianghan
 * @date 2019-07-05 14:42
 */
public class FindSubstring_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Set<String> set  = new HashSet<>();
       // backtrack(set,"",words,0);
        return null;
    }

    /**
     * 回溯法 深度优先遍历
     * 获取所有可能的字符串组合
     * 出口：
     * 回溯单元：
     * 返回值：
     */
    private void backtrack(Set<String> set, String result , List<String> words,int current){
        if(words.size()==0){//出口
            set.add(result);
        }
        for(int i = 0;i<words.size();i++){
            String str = words.get(i);
            words.remove(i);
            backtrack(set,result+words,words,i+1);
        }
    }
}
