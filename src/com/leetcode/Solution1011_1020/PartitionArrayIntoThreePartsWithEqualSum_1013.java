package com.leetcode.Solution1011_1020;

import java.sql.PseudoColumnUsage;

/**
 * 将数组分成和相等的三个部分
 *
 * @author jianghanh
 * @date 2020-03-11 00:07
 */
public class PartitionArrayIntoThreePartsWithEqualSum_1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        int leftSum = 0;
        int leftIndex = -1;
        int rightSum = 0;
        int rightIndex = -1;
        int midSum = 0;
        for(int i : A){
            sum+=i;
        }
        int avg = sum/3;

        for(int i = 0 ;i<A.length-2;i++){
            leftSum+=A[i];
            if(leftSum == avg){
                leftIndex = i;
                break;
            }
        }

        for(int i = A.length-1;i>1;i--){
            rightSum+=A[i];
            if(rightSum == avg){
                rightIndex = i;
                break;
            }
        }

        if(leftIndex>-1&&rightIndex>-1&&leftIndex+1<rightIndex){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] aaa = {12,-4,16,-5,9,-3,3,8,0};
        System.out.println(new PartitionArrayIntoThreePartsWithEqualSum_1013().canThreePartsEqualSum(aaa));
    }
}
