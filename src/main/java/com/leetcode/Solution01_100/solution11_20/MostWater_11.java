package com.leetcode.Solution01_100.solution11_20;

/**
 * 盛最多水的容器
 *
 * @author jianghan
 * @date 2019-06-25 10:18
 */
public class MostWater_11 {
    public int maxArea(int[] height) {
        int maxArea = 0;//初始化最大区域
        int currentArea = 0;//当前区域的大小
        int firstIndex = 0;//首部指针下标
        int lastIndex = height.length-1;//尾部下标
        while (firstIndex<lastIndex) {
            if(height[firstIndex]>=height[lastIndex]){
                currentArea = height[lastIndex] * (lastIndex - firstIndex);
                lastIndex--;
            }else{
                currentArea = height[firstIndex] * (lastIndex - firstIndex);
                firstIndex++;
            }
            maxArea = Math.max(currentArea,maxArea);
        }
        return maxArea;
    }
}
