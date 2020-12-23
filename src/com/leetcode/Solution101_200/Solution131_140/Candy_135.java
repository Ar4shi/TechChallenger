package com.leetcode.Solution101_200.Solution131_140;

/**
 * 分发糖果
 *
 * @author jianghan
 * @date 2020-12-24 00:39
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        int result = 0;
        if (ratings.length == 1) {
            return 1;
        }
        //容器 存放左遍历+右遍历的最优解
        int[] content = new int[ratings.length];
        //全部先给一颗糖
        for (int i = 0; i < ratings.length; i++) {
            content[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                content[i] = content[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                content[i] = Math.max(content[i], content[i + 1] + 1);
            } else {
                content[i] = Math.max(content[i], 1);
            }
            result += content[i];
        }
        //最后一位↑没比到,补充上去
        result += Math.max(content[ratings.length - 1], 1);
        return result;
    }

    public static void main(String[] args) {
        Candy_135 candy_135 = new Candy_135();
        candy_135.candy(new int[]{1, 2, 2});
    }
}
