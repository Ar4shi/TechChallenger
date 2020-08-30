package com.leetcode.Solution01_100.Solution91_100;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 *
 * @author jianghan
 * @date 2020-03-11 09:21
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return BFS(root);
    }

    /**
     * 广度优先遍历层次
     */
    private List<List<Integer>> BFS(TreeNode root){
        //遍历方向标识 0 从左开始 1 从右开始
        int dirction = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> nextStack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            if(dirction == 0){
                for(int i = 0 ;i<size;i++){
                    TreeNode curNode = queue.poll();
                    list.add(curNode.val);
                    if(curNode.left!=null) nextStack.add(curNode.left);
                    if(curNode.right!=null) nextStack.add(curNode.right);
                }
                dirction = 1;
            }else {
                for(int i = 0 ;i<size;i++){
                    TreeNode curNode = queue.poll();
                    list.add(curNode.val);
                    if(curNode.right!=null) nextStack.add(curNode.right);
                    if(curNode.left!=null) nextStack.add(curNode.left);
                }
                dirction = 0;
            }
            res.add(list);
            int stackSize = nextStack.size();
            for(int i = 0 ;i<stackSize;i++){
                queue.add(nextStack.pop());
            }
        }
        return res;
    }
}
