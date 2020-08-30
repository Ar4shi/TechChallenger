package com.leetcode.Solution1101_1200.Solution1151_1160;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 拼写单词
 *
 * @author jianghan
 * @date 2020-03-17 00:56
 */
public class FindWordsThatCanBeFormedByCharacters_1160 {
    public int countCharacters(String[] words, String chars) {
        int length = 0;
        Map<Character,Integer> charsMap = getMap(chars);
        for(String str : words){
            boolean flag = true;
            Map<Character,Integer> strMap = getMap(str);
            for(Character key : strMap.keySet()){
                if(charsMap.get(key)!=null&&charsMap.get(key)>=strMap.get(key)){
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                length += str.length();
            }
        }
        return length;
    }

    private Map<Character,Integer> getMap(String chars){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<chars.length();i++){
            if(map.containsKey(chars.charAt(i))){
                int count = map.get(chars.charAt(i));
                map.put(chars.charAt(i),count+1);
            }else {
                map.put(chars.charAt(i),1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cat","bt","hat","tree"};
        System.out.println(new FindWordsThatCanBeFormedByCharacters_1160().countCharacters(words,"atach"));
    }
}
