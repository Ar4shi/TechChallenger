package com.leetcode.Solution01_100.solution11_20;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @author jianghan
 * @date 2019-06-26 10:07
 */
public class RomanToInteger_13 {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        for(int i =0;i<s.length();i++){
            if(i!=s.length()-1){
                if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){ //若做比右对应的数值小则减，否则则加
                    result-=map.get(s.charAt(i));
                }else{
                    result+=map.get(s.charAt(i));
                }
            }else {
                result+=map.get(s.charAt(i));
            }
        }
        return result;
    }
}
