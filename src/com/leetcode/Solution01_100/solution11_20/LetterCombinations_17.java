package com.leetcode.Solution01_100.solution11_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * @author jianghanh
 * @date 2019-06-26 18:26
 */
public class LetterCombinations_17 {

    private List<String> resultList = new ArrayList<>();
    private Map<Character, String> map = new HashMap<Character, String>()
        {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            if(digits.length()==0) return resultList;
            CombineString("",digits);
            return resultList;
        }

        private void CombineString(String str, String digits) {
            if(digits.length()==0){
                resultList.add(str);
            }else{
                String letter = map.get(digits.charAt(0));//获取当前阶段对应的字符串
                for(int i = 0;i<letter.length();i++){
                    CombineString(str+letter.charAt(i),digits.substring(1));//将str+letter.charAt(i)当参数传入 而不是 令str = str+letter.charAt(i) ！！
                }
            }
        }
    }
