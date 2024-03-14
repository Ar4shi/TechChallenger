package com.leetcode.Solution01_100.Solution31_40;

/**
 * 下一个排列
 *
 * @author jianghan
 * @date 2020-01-23 16:12
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        //反向遍历数组遇到的第一个非升序排列的数字下标
        int firstNumIndex = nums.length - 2;
        //依然反向遍历数组,遇到的第一个比firstNum大的数字的下标,因为是升序的所以它比nums[firstNumIndex]大一丢丢
        int secondNumIndex = nums.length - 1;
        boolean flag = true;
        for (int i = firstNumIndex; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstNumIndex = i;
                flag = false;
                break;
            }
        }
        //正向遍历数组为降序,就是最大的数组,直接倒置
        if (flag) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = secondNumIndex; i > 0; i--) {
            if (nums[i] > nums[firstNumIndex]) {
                secondNumIndex = i;
                break;
            }
        }
        swapNum(nums, firstNumIndex, secondNumIndex);
        //倒置交换后firstNumIndex所在的数组段,由降序改为升序,此时相比之前增加最少
        reverse(nums, firstNumIndex + 1, nums.length - 1);
    }

    /**
     * 交换数组的两个数字的位置
     */
    private void swapNum(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 倒置数组的某个区间
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swapNum(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation_31 nextPermutation_31 = new NextPermutation_31();
        nextPermutation_31.nextPermutation(new int[]{2, 3, 1});
    }
}
