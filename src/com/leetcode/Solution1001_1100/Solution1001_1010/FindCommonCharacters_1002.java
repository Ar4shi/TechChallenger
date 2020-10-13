package com.leetcode.Solution1001_1100.Solution1001_1010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查找常用字符
 *
 * @author jianghan
 * @date 2020-10-14 00:12
 */
public class FindCommonCharacters_1002 {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] resultArray = new int[26];
        List<Integer[]> list = new ArrayList<>();
        for (String str : A) {
            Integer[] array = new Integer[26];
            for (int i = 0; i < str.length(); i++) {
                if (array[str.charAt(i) - 'a'] == null) {
                    array[str.charAt(i) - 'a'] = 1;
                } else {
                    array[str.charAt(i) - 'a'] += 1;
                }
            }
            list.add(array);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 26; j++) {
                if (i == 0) {
                    resultArray[j] = list.get(i)[j] == null ? 0 : list.get(i)[j];
                } else {
                    resultArray[j] = Math.min(list.get(i)[j] == null ? 0 : list.get(i)[j], resultArray[j]);
                }
            }
        }
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] > 0) {
                for (int j = 0; j < resultArray[i]; j++) {
                    result.add(String.valueOf((char) ('a' + i)));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacters_1002 FindCommonCharacters_1002 = new FindCommonCharacters_1002();
        FindCommonCharacters_1002.commonChars(new String[]{"bella", "label", "roller"});
    }
}
