package com.leetcode.Solution01_100.Solution51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 *
 * @author jianghan
 * @date 2020-11-04 23:42
 */
public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean isAdd = false;
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                //当前区间在插入区间右侧且无交集
                if (!isAdd) {
                    //如果还没有加入列表则加入
                    list.add(new int[]{left, right});
                    isAdd = true;
                }
                list.add(interval);
            } else if (interval[1] < left) {
                //当前区间在插入区间左侧且无交集
                //这里不需要判断isAdd是因为插入特定区间操作完全委托于前一个判断
                list.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        //没有遍历到说明在最后
        if (!isAdd) {
            list.add(new int[]{left, right});
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
