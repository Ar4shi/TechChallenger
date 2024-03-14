package com.interview.easy;

import com.leetcode.TreeNode;

public class MinimumHeightTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int middleIndex = (nums.length - 1) / 2;
        TreeNode head = new TreeNode(nums[middleIndex]);
        head.left = buildTree(nums, 0, middleIndex - 1);
        head.right = buildTree(nums, middleIndex + 1, nums.length - 1);
        return head;
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int middleIndex = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[middleIndex]);
        treeNode.left = buildTree(nums, left, middleIndex - 1);
        treeNode.right = buildTree(nums, middleIndex + 1, right);
        return treeNode;
    }
}
