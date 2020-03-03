package com.leetcode.Solution91_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 *
 * @author jianghanh
 * @date 2020-03-03 00:21
 */
public class BinaryTreeInorderTraversal_94 {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal_94 binaryTreeInorderTraversal_94 = new BinaryTreeInorderTraversal_94();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        binaryTreeInorderTraversal_94.inorderTraversal(a);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return Dfs(root);
    }

    /**
     * 递归方式实现中序遍历
     */
    private List<Integer> recurrence(TreeNode root,List<Integer> resultList){

        if(root==null){
            return resultList;
        }else {
            recurrence(root.left,resultList);
            resultList.add(root.val);
            recurrence(root.right,resultList);
            return resultList;
        }

    }

    /**
     * (迭代)模拟深度优先算法
     * 本质是利用栈来模拟计算机递归过程
     * 1、垂直遍历所有左节点压入堆栈直至最左叶子节点，令其出栈压入线性表
     * 2、继续出栈压入线性表
     * 3、递归调用步骤【1】的操作直至栈为空且当前节点为null
     */
    private List<Integer> Dfs(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();

        while(stack.size()>0||root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode node = stack.pop();
                resultList.add(node.val);
                root = node.right;
            }
        }

        return resultList;
    }
}

