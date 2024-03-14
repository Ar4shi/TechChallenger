package com.leetcode.Solution101_200.Solution111_120;

import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角 II
 *
 * @author jianghan
 * @date 2021-02-12 22:41
 */
public class PascalTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return new ArrayList<Integer>(){{
                this.add(1);
            }};
        }
        Integer[][] array = new Integer[rowIndex + 1][rowIndex + 1];
        array[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            array[i][0] = 1;
            array[i][i] = 1;
            for (int j = 1; j < i ; j++) {
                array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
            }
        }
        return Arrays.asList(array[rowIndex]);
    }

    public static void main(String[] args) {
        PascalTriangleII_119 pascalTriangleII_119 = new PascalTriangleII_119();
        pascalTriangleII_119.getRow(3);
    }
}
