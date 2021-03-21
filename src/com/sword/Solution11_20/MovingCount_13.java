package com.sword.Solution11_20;

/**
 * 剑指 Offer 13. 机器人的运动范围
 *
 * @author jianghan
 * @date 2021-03-21 16:40
 */
public class MovingCount_13 {
    int[][] map;
    int k;
    int result;

    public int movingCount(int m, int n, int k) {
        this.map = new int[m][n];
        this.k = k;
        dfs(0, 0);
        return result;
    }

    /**
     * 回溯条件和上一题几乎一样
     * 不过这道题不需要回溯map因为走过就不能走了
     */
    private void dfs(int i, int j) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[i].length) {
            return;
        }
        if (map[i][j] != 0) {
            return;
        }
        if (!canMove(i, j)) {
            return;
        }
        result++;
        map[i][j] = 1;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    private boolean canMove(int i, int j) {
        int sum = 0;
        do {
            sum += i % 10;
            i /= 10;
        } while (i  > 0);
        do {
            sum += j % 10;
            j /= 10;
        } while (j  > 0);
        return sum <= this.k;
    }

    public static void main(String[] args) {
        MovingCount_13 movingCount_13 = new MovingCount_13();
        System.out.println(movingCount_13.movingCount(38, 15, 9));
    }
}
