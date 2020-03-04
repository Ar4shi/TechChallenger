package com.leetcode.Solution991_1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 *
 * 动态规划：
 * 首先想到的算法
 * 由于每次腐化需要用到上一次腐化的状态
 * 所以记录上一次的状态用于下一次计算
 *
 * @author jianghanh
 * @date 2020-03-04 10:58
 */
public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        int[][] curGrid = currentState(grid);
        while (!isSameSate(grid,curGrid)){
            result++;
            grid = curGrid;
            curGrid = currentState(curGrid);
        }
        if(!isComplete(curGrid)){
            result = -1;
        }
        return result;
    }

    /**
     * 记录每次腐化完成后数组的状态
     */
    private int[][] currentState(int[][] preGrid){
        int[][] curGrid = new int[preGrid.length][preGrid[preGrid.length-1].length];
        for(int i = 0;i<preGrid.length;i++){
            for(int j = 0;j<preGrid[i].length;j++){
                /*如果新状态还处于初始化阶段,则直接把旧状态对应位置的状态放入*/
                if(curGrid[i][j] == 0){
                    curGrid[i][j] = preGrid[i][j];
                }
                /*如果旧状态为腐化状态,则腐化四周单元格*/
                if(preGrid[i][j] == 2){
                    /*上*/
                    if(i-1>=0&&preGrid[i-1][j]==1){
                        curGrid[i-1][j] = 2;
                    }
                    /*下*/
                    if(i+1<preGrid.length&&preGrid[i+1][j]==1){
                        curGrid[i+1][j] = 2;
                    }
                    /*左*/
                    if(j-1>=0&&preGrid[i][j-1]==1){
                        curGrid[i][j-1] = 2;
                    }
                    /*右*/
                    if(j+1<preGrid[i].length&&preGrid[i][j+1]==1){
                        curGrid[i][j+1] = 2;
                    }
                }
            }
        }
        return curGrid;
    }

    /**
     * 判断前后状态是否一样
     */
    private boolean isSameSate(int[][] preGrid,int[][] curGrid){
        for(int i = 0 ;i<preGrid.length;i++){
            for(int j = 0;j<preGrid[i].length;j++){
                if(preGrid[i][j]!=curGrid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断是否完全腐化
     */
    private boolean isComplete(int[][] grid){
        for(int i = 0 ;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * 算法二：利用广度优先搜索
 * 利用队列
 * 对grid腐化过程转化为对未腐化橘子的可达性分析
 */
class RottingOranges_994_2 {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        //记录初始状态下未腐化橘子的个数
        int count = 0;
        //此队列用来存储需要对四周进行腐化的数组坐标
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count++;
                }
                if(grid[i][j]==2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (count>0&&!queue.isEmpty()){
            result++;
            //当前轮次队列中的烂橘子都消耗光才进入一下论
            int n = queue.size();
            for(int k = 0;k<n;k++){
                int[] index = queue.poll();
                //当前等待腐化周围的橘子的坐标
                int i = index[0];
                int j = index[1];

                /*上*/
                if(i-1>=0&&grid[i-1][j]==1){
                    grid[i-1][j] = 2;
                    count--;
                    queue.add(new int[]{i-1,j});
                }
                /*下*/
                if(i+1<grid.length&&grid[i+1][j]==1){
                    grid[i+1][j] = 2;
                    count--;
                    queue.add(new int[]{i+1,j});
                }
                /*左*/
                if(j-1>=0&&grid[i][j-1]==1){
                    grid[i][j-1] = 2;
                    count--;
                    queue.add(new int[]{i,j-1});
                }
                /*右*/
                if(j+1<grid[i].length&&grid[i][j+1]==1){
                    grid[i][j+1] = 2;
                    count--;
                    queue.add(new int[]{i,j+1});
                }
            }
        }
        if(count!=0){
            result = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges_994_2 rottingOranges_994_2 = new RottingOranges_994_2();
        System.out.println(rottingOranges_994_2.orangesRotting(a));
    }
}