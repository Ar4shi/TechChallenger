package com.interview.easy;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * <p>
 * 示例2:
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * <p>
 * 提示:
 * words的长度在[1, 1000000]之间
 */
public class SparseArraySearch {
    public int findString(String[] words, String s) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int left = 0;
        int right = words.length - 1;
        while (left <= right) {
            while (left <= right && words[left].isEmpty()) {
                left++;
            }
            while (left <= right && words[right].isEmpty()) {
                right--;
            }
            // 这种写法相对于 mid = (left + right) / 2; 避免了溢出
            int mid = left + (right - left) / 2;
            // 向左向右都可以
            while (mid < right && words[mid].isEmpty()) {
                mid++;
            }
            if (words[mid].equals(s)) {
                return mid;
            }
            if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
