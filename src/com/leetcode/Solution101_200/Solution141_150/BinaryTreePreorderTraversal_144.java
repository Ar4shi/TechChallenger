package com.leetcode.Solution101_200.Solution141_150;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * @author jianghanh
 * @date 2020-03-06 13:33
 */
public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return recursion(root,new ArrayList<>());
    }

    /**
     * 递归
     * DFS
     */
    private List<Integer> recursion(TreeNode root,List<Integer> list){
        /**
         * 递归出口
         */
        if(root==null){
            return list;
        }else {
            list.add(root.val);
            recursion(root.left,list);
            recursion(root.right,list);
        }
        return list;
    }

    /**
     * 迭代
     * DFS
     */
    private List<Integer> iterator(TreeNode root){
        return null;
    }
}
