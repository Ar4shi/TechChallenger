package com.leetcode.Solution401_500.Solution401_410;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 根据身高重建队列
 *
 * @author jianghan
 * @date 2020-11-16 22:50
 */
public class QueueReconstructionByHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                //如果身高相等,按照排位升序排列
                return p1[1] - p2[1];
            } else {
                //如果身高不等.按照身高降序排列
                return p2[0] - p1[0];
            }
        });
        //插队思想,高个子先排进去,矮个子根据K值放-插入-到相应的位置
        List<int[]> result = new LinkedList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[0][0]);
    }
}
