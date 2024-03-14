package com.leetcode.Solution201_300.Solution221_230;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 *
 * @author jianghan
 * @date 2020-09-14 00:27
 */
public class SummaryRanges_228 {
    int start;
    int last;
    int last2;

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                start = nums[i];
                last = nums[i];
            } else {
                if (nums[i] - last != 1) {
                    if (start == last) {
                        result.add(start + "");
                    } else {
                        result.add(start + "->" + last);
                    }
                    start = nums[i];
                    last = nums[i];
                } else {
                    last = nums[i];
                }
            }
            if (i == nums.length - 2) {
                last2 = nums[i];
            }
        }
        if (last - last2 == 1) {
            result.add(start + "->" + last);
        } else {
            result.add("" + last);
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges_228 summaryRanges_228 = new SummaryRanges_228();
        summaryRanges_228.summaryRanges(new int[]{1, 2});
    }
}
