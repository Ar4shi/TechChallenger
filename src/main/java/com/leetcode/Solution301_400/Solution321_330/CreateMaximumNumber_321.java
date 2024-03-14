package com.leetcode.Solution301_400.Solution321_330;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 拼接最大数
 *
 * @author jianghan
 * @date 2020-12-20 13:40
 */
public class CreateMaximumNumber_321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i <= nums1.length; i++) {
            if ((k - i) <= nums2.length) {
                Integer[] array1 = getMax(nums1, i);
                Integer[] array2 = getMax(nums2, k - i);
                list.add(merge(array1, array2));
            }
        }
        Integer[] maxArray = getMaxArray(list);
        int[] result = new int[maxArray.length];
        for (int i = 0; i < maxArray.length; i++) {
            result[i] = maxArray[i];
        }
        return result;
    }

    /**
     * 利用单调栈获取最大数组
     */
    private Integer[] getMax(int[] array, int count) {
        if (count == 0) {
            return new Integer[0];
        }
        Stack<Integer> stack = new Stack<>();
        int remainLength = array.length;
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.add(array[i]);
            } else {
                boolean isAdd = false;
                while (stack.size() + remainLength > count) {
                    if (!stack.isEmpty()) {
                        if (array[i] > stack.peek()) {
                            stack.pop();
                        } else {
                            if (stack.size() < count) {
                                stack.add(array[i]);
                                isAdd = true;
                            }
                            break;
                        }
                    } else {
                        if (stack.size() < count) {
                            stack.add(array[i]);
                            isAdd = true;
                        }
                        break;
                    }
                }
                if (!isAdd && stack.size() < count) {
                    stack.add(array[i]);
                }
            }
            remainLength--;
        }
        return stack.toArray(new Integer[0]);
    }

    /**
     * 合并两个数组,得到最大数组
     */
    private Integer[] merge(Integer[] array1, Integer[] array2) {
        if (array1.length == 0) {
            return array2;
        }
        if (array2.length == 0) {
            return array1;
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] > array2[j]) {
                list.add(array1[i]);
                i++;
            } else if (array1[i].equals(array2[j])) {
                int m = i + 1;
                int n = j + 1;
                boolean isCompared = false;
                //用双指针merge的时候要把值相等的情况单独拎出来，通过比较后面几位的大小情况才能确定用哪个数组的值
                while (m < array1.length && n < array2.length) {
                    if (array1[m] < array2[n]) {
                        list.add(array2[j]);
                        j++;
                        isCompared = true;
                        break;
                    } else if (array1[m] > array2[n]) {
                        list.add(array1[i]);
                        i++;
                        isCompared = true;
                        break;
                    } else {
                        m++;
                        n++;
                    }
                }
                if (!isCompared) {
                    if (m == array1.length) {
                        list.add(array2[j]);
                        j++;
                    } else {
                        list.add(array1[i]);
                        i++;
                    }
                }
            } else {
                list.add(array2[j]);
                j++;
            }
        }
        for (int m = i; m < array1.length; m++) {
            list.add(array1[m]);
        }
        for (int m = j; m < array2.length; m++) {
            list.add(array2[m]);
        }
        return list.toArray(new Integer[0]);
    }

    /**
     * 获取最大数组
     */
    private Integer[] getMaxArray(List<Integer[]> list) {
        Integer[] max = list.get(0);
        int arrayLength = max.length;
        if (list.size() == 1) {
            return max;
        }
        for (int i = 1; i < list.size(); i++) {
            Integer[] array = list.get(i);
            for (int j = 0; j < arrayLength; j++) {
                if (array[j] > max[j]) {
                    max = array;
                    break;
                } else if (array[j] < max[j]) {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CreateMaximumNumber_321 createMaximumNumber_321 = new CreateMaximumNumber_321();
        createMaximumNumber_321.maxNumber(new int[]{2, 5, 6, 4, 4, 0}, new int[]{7, 3, 8, 0, 6, 5, 7, 6, 2}, 15);
    }
}
