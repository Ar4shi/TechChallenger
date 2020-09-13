package com.leetcode.Solution01_100.Solution71_80;

/**
 * 单词搜索
 *
 * @author jianghan
 * @date 2020-09-13 21:16
 */
public class WordSearch_79 {
    boolean result = false;
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (result) {
                    return true;
                } else {
                    recursion(x, y, new int[board.length][board[0].length], 0);
                }
            }
        }
        return result;
    }

    private void recursion(int x, int y, int[][] board, int count) {
        if (count == word.length() || result) {
            result = true;
            return;
        }
        if (!(x < 0 || y < 0 || x >= this.board.length || y >= this.board[0].length || board[x][y] == 1)) {
            if (this.board[x][y] == word.charAt(count)) {
                board[x][y] = 1;
                //上下左右各走一遍
                recursion(x, y - 1, board, count + 1);
                recursion(x, y + 1, board, count + 1);
                recursion(x - 1, y, board, count + 1);
                recursion(x + 1, y, board, count + 1);
                //回溯
                board[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        WordSearch_79 wordSearch_79 = new WordSearch_79();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(wordSearch_79.exist(board, "ABCCED"));
    }
}
