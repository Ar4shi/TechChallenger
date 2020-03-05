package com.leetcode.Solution91_100;

import com.leetcode.Solution1101_1110.TreeNode;

/**
 * 验证二叉搜索树
 *
 * @author jianghanh
 * @date 2020-03-01 14:49
 */
public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        return check(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    private boolean check(TreeNode root,int max,int min){
        if(root == null) return true;
        if(root.val>=max||root.val<=min) return false;
        boolean leftFlag = check(root.left,root.val,min);
        boolean rightFlag = check(root.right,max,root.val);
        return leftFlag&&rightFlag;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(20);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        ValidateBinarySearchTree_98 validateBinarySearchTree_98 = new ValidateBinarySearchTree_98();
        System.out.println(validateBinarySearchTree_98.isValidBST(a));
    }
}


