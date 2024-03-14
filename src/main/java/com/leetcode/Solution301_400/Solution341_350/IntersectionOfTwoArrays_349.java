package com.leetcode.Solution301_400.Solution341_350;

import java.util.*;

/**
 * 两个数组的交集
 *
 * @author jianghan
 * @date 2020-11-02 02:26
 */
public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        Iterator<Integer> iterator1 = set1.iterator();
        Iterator<Integer> iterator2 = set2.iterator();
        while (iterator1.hasNext()) {
            Integer first = iterator1.next();
            while (iterator2.hasNext()) {
                Integer second = iterator2.next();
                if (first.equals(second)) {
                    result.add(first);
                }
            }
            iterator2 = set2.iterator();
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays_349 intersectionOfTwoArrays_349 = new IntersectionOfTwoArrays_349();
        intersectionOfTwoArrays_349.intersection(new int[]{1,2,2,1},new int[]{2,2});
    }
}
