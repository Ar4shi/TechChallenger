package com.leetcode.Solution101_200.Solution121_130;

import java.util.*;

/**
 * 单词接龙
 * DFS超时
 * 无向图用BFS节省复杂度
 * @author jianghan
 * @date 2020-11-05 23:27
 */
public class WordLadder_127 {
    int min = 0;
    String endWord;
    List<String> wordList;

    //BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，然后恢复
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }

    //DFS超时
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }
        this.endWord = endWord;
        this.wordList = wordList;
        recursion(0, beginWord, new int[wordList.size()]);
        return min;
    }

    private void recursion(int count, String word, int[] index) {
        if (count == wordList.size()) {
            return;
        }
        for (int i = 0; i < index.length; i++) {
            if (index[i] == 0 && canTransform(word, wordList.get(i)) && (min == 0 || count + 2 < min)) {
                if (endWord.equals(wordList.get(i))) {
                    if (min == 0) {
                        min = count + 2;
                    } else {
                        min = Math.min(min, count + 2);
                    }
                    return;
                } else {
                    index[i] = 1;
                    recursion(count + 1, wordList.get(i), index);
                    index[i] = 0;
                }
            }
        }
    }

    private boolean canTransform(String word1, String word2) {
        int difference = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                difference++;
            }
        }
        return difference == 1;
    }

    public static void main(String[] args) {
        WordLadder_127 wordLadder_127 = new WordLadder_127();
        wordLadder_127.ladderLength("lost", "miss", Arrays.asList("most", "mist", "miss", "lost", "fist", "fish"));
    }
}
