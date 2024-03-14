package com.leetcode.Solution101_200.Solution141_150;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author jianghan
 * @date 2020-03-06 10:36
 */
public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        return recursion(root,new ArrayList<>());
    }

    /**
     * 二叉树的后序遍历
     * 递归
     */
    private List<Integer> recursion(TreeNode root,List<Integer> list){
        /**
         * 递归出口
         */
        if(root==null){
            return list;
        }else {
            recursion(root.left,list);
            recursion(root.right,list);
            list.add(root.val);
            return list;
        }
    }

    /**
     * 迭代
     * 利用Stack模拟DFS的递归过程
     */
    private List<Integer> iterator(TreeNode root){
        return null;
    }
}
