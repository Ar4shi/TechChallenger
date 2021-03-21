package com.sword.Solution11_20;

/**
 * 剑指 Offer 12. 矩阵中的路径
 *
 * @author jianghan
 * @date 2021-03-21 13:43
 */
public class Exist_12 {
    char[][] board;
    String word;
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!result) {
                    recursion(i, j, new int[board.length][board[i].length], 0);
                }
            }
        }
        return result;
    }

    /**
     * 每一次寻找下一个路径的过程都是类似的
     * 以递归的方式实现
     */
    private void recursion(int i, int j, int[][] state, int index) {
        //剪枝条件 减少运行次数
        if (result) {
            return;
        }
        //得到了正确的结果
        if (index >= word.length()) {
            result = true;
            return;
        }
        //不符合边界 直接回溯
        if (i < 0 || i >= state.length || j < 0 || j >= state[i].length) {
            return;
        }
        //这个点已经被取过了 直接回溯
        if (state[i][j] != 0) {
            return;
        }
        //没有匹配上 直接回溯
        char currentChar = word.charAt(index);
        if (board[i][j] != currentChar) {
            return;
        }
        state[i][j] = 1;
        //上下左右依次尝试
        recursion(i - 1, j, state, index + 1);
        recursion(i + 1, j, state, index + 1);
        recursion(i, j - 1, state, index + 1);
        recursion(i, j + 1, state, index + 1);
        //回溯
        state[i][j] = 0;
    }
}
