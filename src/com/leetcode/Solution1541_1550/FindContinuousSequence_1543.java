package com.leetcode.Solution1541_1550;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 *
 * @author jianghanh
 * @date 2020-03-06 00:42
 */
public class FindContinuousSequence_1543 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        int max = 0;
        int copy = target;
        for(int i = 1;i<copy;i++){
            int flag = i;
            List<Integer> list = new ArrayList<>();
            while (target>0){
                list.add(flag);
                target -= flag;
                flag++;
            }
            if (target==0){
                int[] temp = new int[list.size()];
                for(int m = 0;m<list.size();m++){
                    temp[m] = list.get(m);
                }
                lists.add(temp);
                max = Math.max(max,list.size());
            }
            target = copy;
        }
        int[][] res = new int[lists.size()][];
        for(int i = 0 ;i<lists.size();i++){
            res[i] = lists.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        FindContinuousSequence_1543 findContinuousSequence_1543 = new FindContinuousSequence_1543();
        findContinuousSequence_1543.findContinuousSequence(9);
    }
}
