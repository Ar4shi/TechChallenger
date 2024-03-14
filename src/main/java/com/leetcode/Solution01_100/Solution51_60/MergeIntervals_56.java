package com.leetcode.Solution01_100.Solution51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并区间
 *
 * @author jianghan
 * @date 2020-09-08 23:56
 */
public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length <= 1) {
            return intervals;
        }
        for (int i = 0; i < intervals.length; i++) {
            if (list.size() == 0) {
                list.add(intervals[i]);
            } else {
                int left = intervals[i][0];
                int right = intervals[i][1];
                for (int[] array : list) {
                    int arrayleft = array[0];
                    int arrayright = array[1];

                    if(arrayright<left){//分开

                    }else if(arrayleft>right){//分开

                    }else if(arrayleft<left&&arrayright<=right){//[arrayleft,right]

                    }else if(arrayleft<left&&arrayright>right){//[arrayleft,arrayright]

                    }else if(arrayleft>=left&&arrayright<=right){//[left,right]

                    }else if(arrayleft>=left){//[left,arrayright]

                    }
                }
            }
        }
        return null;
    }
}
