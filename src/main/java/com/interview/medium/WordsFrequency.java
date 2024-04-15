package com.interview.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * <p>
 * get(word)查询指定单词在书中出现的频率
 * <p>
 * 示例：
 * <p>
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * <p>
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * <p>
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * <p>
 * wordsFrequency.get("an"); //返回1
 * <p>
 * wordsFrequency.get("apple"); //返回1
 * <p>
 * wordsFrequency.get("pen"); //返回1
 * <p>
 * 提示：
 * <p>
 * book[i]中只包含小写字母
 * <p>
 * 1 <= book.length <= 100000
 * <p>
 * 1 <= book[i].length <= 10
 * <p>
 * get函数的调用次数不会超过100000
 */
public class WordsFrequency {

    private Map<String,Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for (String s : book) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}
