package com.leetcode.Solution01_100.Solution51_60;

/**
 * 螺旋矩阵 II
 *
 * @author jianghan
 * @date 2020-09-23 01:42
 */
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        //0 右 1下 2左 3上  循环
        int flag = 0;
        //当前坐标
        int[] content = {0,0};
        int[][] result = new int[n][n];
        for(int i = 1;i<=n*n;i++){
            if(flag==0){
                if(content[0]<n&&content[1]<n&&result[content[0]][content[1]]==0){
                    result[content[0]][content[1]]=i;
                    content[1]+=1;
                }else {
                    flag=1;

                }
            }else if(flag==1){

            }else if(flag==2){

            }else if(flag==3){

            }
        }
        return result;
    }
}