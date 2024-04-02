package com.interview.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * <p>[
 * <p>[".Q..",  // 解法 1
 * <p>"...Q",
 * <p>"Q...",
 * <p>"..Q."],
 * <p>
 * <p>["..Q.",  // 解法 2
 * <p>"Q...",
 * <p>"...Q",
 * <p>".Q.."]
 * <p>]
 */
public class EightQueens {

    private final static String QUEEN = "Q";

    private final static String EMPTY = ".";

    List<List<String>> result;

    int[][] board;

    int n;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        this.n = n;
        for (int x = 0; x < n; x++) {
            dfs(x, 0);
        }
        return result;
    }

    private void dfs(int row, int col) {
        if (row >= n || col >= n) {
            return;
        }
        if (!check(row, col)) {
            return;
        }
        board[row][col] = 1;
        // 只需要判断纵坐标,因为下方的遍历是从上到下的
        if (col == n - 1 && checkBoardComplete(row, col)) {
            result.add(convertBoardToList());
            board[row][col] = 0;
            return;
        }
        for (int y = col + 1; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (x == row) {
                    continue;
                }
                dfs(x, y);
            }
        }
        board[row][col] = 0;
    }

    private boolean checkBoardComplete(int row, int col) {
        int count = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 1) {
                    count++;
                }
            }
        }
        return count == n;
    }

    private List<String> convertBoardToList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    sb.append(QUEEN);
                } else {
                    sb.append(EMPTY);
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    private boolean check(int row, int col) {
        for (int x = 0; x < row; x++) {
            if (board[x][col] == 1) {
                return false;
            }
        }
        for (int y = 0; y < col; y++) {
            if (board[row][y] == 1) {
                return false;
            }
        }
        // 往左上遍历
        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--) {
            if (board[x][y] == 1) {
                return false;
            }
        }
        // 往右上遍历
        for (int x = row, y = col; x < n && y >= 0; x++, y--) {
            if (board[x][y] == 1) {
                return false;
            }
        }
        return true;
    }
}
