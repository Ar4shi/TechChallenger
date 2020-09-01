package com.leetcode.Solution01_100.Solution31_40;

/**
 * 有效的数独
 *
 * @author jianghan
 * @date 2020-09-02 00:58
 */
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        return getRowCheck(board) && getColumCheck(board) && getNineBlockCheck(board);
    }

    private boolean getRowCheck(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] content = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (content[(board[i][j]) - (int) '0' - 1] == 1) {
                        return false;
                    } else {
                        content[(board[i][j]) - (int) '0' - 1] = 1;
                    }
                }
            }
        }
        return true;
    }

    private boolean getColumCheck(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] content = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (content[(board[j][i]) - (int) '0' - 1] == 1) {
                        return false;
                    } else {
                        content[(board[j][i]) - (int) '0' - 1] = 1;
                    }
                }
            }
        }
        return true;
    }

    private boolean getNineBlockCheck(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] content = new int[9];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[m + i * 3][n + j * 3] != '.') {
                            if (content[(board[m + i * 3][n + j * 3]) - (int) '0' - 1] == 1) {
                                return false;
                            } else {
                                content[(board[m + i * 3][n + j * 3]) - (int) '0' - 1] = 1;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        ValidSudoku_36 validSudoku_36 = new ValidSudoku_36();
        System.out.println(validSudoku_36.isValidSudoku(board));
    }
}
