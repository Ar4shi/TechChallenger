package com.leetcode.Solution91_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树 II
 *
 * @author jianghanh
 * @date 2020-03-03 22:56
 */
public class UniqueBinarySearchTreesII_95 {

    public List<TreeNode> generateTrees(int n) {
        if(n<1) return new ArrayList<TreeNode>();
        if(n==1){
            List<TreeNode> treeNodes = new ArrayList<>();
            TreeNode treeNode = new TreeNode(1);
            treeNodes.add(treeNode);
            return treeNodes;
        }
        return recursion(1,n);
    }

    /**
     * 递归方式
     */
    private List<TreeNode> recursion(int start ,int end){

        /*
         * 每次递归相当于生成新的子树结果集,然后排列组合
         * 所以每次递归都需要NEW一个线性表存储当前递归阶段的子树
         */
        List<TreeNode> treeNodes = new ArrayList<>();

        /*
         * 这一段是核心
         * 可以理解成当start = i 或 end = i 时
         * 本次递归生成的左(右)子树为空
         *
         * 左右子树即使为null,也是排列组合中的一种情况,如果不加这一段
         * 当执行到 for(TreeNode leftTree:leftTrees)
         * 则无法进入循环体,导致无法与右子树进行组合
         */
        if(start>end){
            treeNodes.add(null);
            return treeNodes;
        }

        for(int i = start;i<=end;i++){

            //全部可能的左子树的集合
            List<TreeNode> leftTrees = recursion(start, i - 1);
            //全部可能的右子树的集合
            List<TreeNode> rightTrees = recursion(i + 1, end);

            for(TreeNode leftTree:leftTrees){
                for(TreeNode rightTree:rightTrees){
                    //树(子树)的根节点
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTree;
                    treeNode.right = rightTree;
                    treeNodes.add(treeNode);
                }
            }
        }

        return treeNodes;
    }
}
