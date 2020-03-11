package com.leetcode.Solution101_200.Solution101_110;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * @author jianghanh
 * @date 2020-03-07 11:29
 */
public class MaximumDepthOfBinaryTree_104 {
    int res = 0;
    public int maxDepth(TreeNode root) {
        return BFS(root);
    }

    /**
     * 方案一
     * 深度优先
     * DFS(root,0);
     */
    private int DFS(TreeNode root,int rank){
        if(root==null){
            res = Math.max(rank,res);
        }else {
            rank ++;
            DFS(root.left,rank);
            DFS(root.right,rank);
        }

        return res;
    }

    /**
     * 方案二
     * 广度优先
     * BFS(root);
     */
    private int BFS(TreeNode root){
        int rank = 0;
        Queue<TreeNode> queue = new LinkedList <>();
        if(root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            rank ++;
            for(int i = 0 ;i<size;i++){
                TreeNode curNode = queue.poll();
                if(curNode.left!=null){
                    queue.add(curNode.left);
                }
                if(curNode.right!=null){
                    queue.add(curNode.right);
                }
            }
        }
        return rank;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree_104 maximumDepthOfBinaryTree_104 = new MaximumDepthOfBinaryTree_104();
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(-1);
        TreeNode g = new TreeNode(5);
        TreeNode h = new TreeNode(1);
        TreeNode i = new TreeNode(6);
        TreeNode j = new TreeNode(8);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.right = g;
        d.right = h;
        e.right = i;
        f.right = j;
        System.out.println(maximumDepthOfBinaryTree_104.maxDepth(a));
    }
}
