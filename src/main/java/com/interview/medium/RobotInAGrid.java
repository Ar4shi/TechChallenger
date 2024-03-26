package com.interview.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * <p>
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 */
public class RobotInAGrid {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 记录已经访问过的位置
     */
    int[][] visitedGrid;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        visitedGrid = new int[obstacleGrid.length][obstacleGrid[0].length];
        dfs(new ArrayList<>(), obstacleGrid, 0, 0);
        return result;
    }

    private void dfs(List<List<Integer>> cacheResult, int[][] obstacleGrid, int x, int y) {
        if (result.size() != 0) {
            return;
        }
        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length) {
            return;
        }
        if (obstacleGrid[x][y] == 1) {
            visitedGrid[x][y] = 1;
            return;
        }
        if (visitedGrid[x][y] == 1) {
            return;
        }
        List<List<Integer>> listCopy = new ArrayList<>(cacheResult);
        List<Integer> current = new ArrayList<>();
        current.add(x);
        current.add(y);
        listCopy.add(current);
        visitedGrid[x][y] = 1;
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            result = new ArrayList<>(listCopy);
            return;
        }
        dfs(listCopy, obstacleGrid, x + 1, y);
        dfs(listCopy, obstacleGrid, x, y + 1);
    }
}
