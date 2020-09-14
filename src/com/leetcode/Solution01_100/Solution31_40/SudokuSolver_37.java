package com.leetcode.Solution01_100.Solution31_40;

/**
 * 解数独
 *
 * @author jianghan
 * @date 2020-09-15 00:49
 */
public class SudokuSolver_37 {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    row[i][index] = true;
                    col[j][index] = true;
                    //把九宫格转换成3*3的区域 此处理解为区域[m][n]中[index]为已用数字
                    block[i / 3][j / 3][index] = true;
                }
            }
        }
        recursion(board, 0, 0);
    }

    private boolean recursion(char[][] board, int i, int j) {
        if (i > 8) {
            return true;
        }
        if (board[i][j] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                int index = c - '1';
                if (row[i][index] || col[j][index] || block[i / 3][j / 3][index]) {
                    continue;
                }
                board[i][j] = c;
                row[i][index] = true;
                col[j][index] = true;
                block[i / 3][j / 3][index] = true;
                // 九宫格的下一个格子的坐标的算法
                if (recursion(board, i + (j + 1) / 9, (j + 1) % 9)) {
                    return true;
                }
                //回溯
                board[i][j] = '.';
                row[i][index] = false;
                col[j][index] = false;
                block[i / 3][j / 3][index] = false;
            }
        } else {
            return recursion(board, i + (j + 1) / 9, (j + 1) % 9);
        }
        return false;
    }
}
