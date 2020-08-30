package com.leetcode.Solution1101_1200.Solution1101_1110;

/**
 * 分糖果 II
 *
 * @author jianghan
 * @date 2020-03-05 00:24
 */
public class DistributeCandiesToPeopleII_1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        //起始给予的糖果数
        int curNum = 1;
        //数组起始坐标
        int index = 0;
        while (candies>0){

            if(curNum<=candies){
                res[index] += curNum;
                candies -= curNum;
                curNum++;
            }else {
                res[index] += candies;
                candies = 0;
            }

            if(index+1==num_people){
                index = 0;
            }else {
                index++;
            }

        }
        return res;
    }
}
