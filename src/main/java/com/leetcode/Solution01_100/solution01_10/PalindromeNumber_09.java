package com.leetcode.Solution01_100.solution01_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文数
 *
 * @author jianghan
 * @date 2019-06-23 14:20
 */
public class PalindromeNumber_09 {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x<10) return true;
        List<Integer> valueList = new ArrayList<>();
        while (x!=0){
            valueList.add(x%10);
            x = x/10;
        }
        for(int i =0;i<valueList.size()/2;i++){
            if(valueList.get(i)!=valueList.get(valueList.size()-i-1)) return false;
        }
        return true;
    }
}
