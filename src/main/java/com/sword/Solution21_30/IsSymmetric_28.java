package com.sword.Solution21_30;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 28. 对称的二叉树
 *
 * @author jianghan
 * @date 2021-03-29 23:23
 */
public class IsSymmetric_28 {

    boolean result;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return result;
    }

    private void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
        }
    }

    private void checkSymmetric(){

    }
}
