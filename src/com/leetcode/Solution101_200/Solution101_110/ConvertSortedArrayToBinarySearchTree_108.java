package com.leetcode.Solution101_200.Solution101_110;

import com.leetcode.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author jianghanh
 * @date 2020-03-07 16:42
 */
public class ConvertSortedArrayToBinarySearchTree_108 {

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return DFS(0,nums.length-1);
    }

    /**
     * 二叉搜索树的中序遍历
     * 便是升序数组
     */
    private TreeNode DFS(int left,int right){
        TreeNode treeNode = null;
        if(left>right){
            return treeNode;
        }else{
            treeNode = new TreeNode(nums[(left+right)/2]);
            treeNode.left = DFS(left,(left+right)/2-1);
            treeNode.right = DFS((left+right)/2+1,right);
        }
        return treeNode;
    }
}
