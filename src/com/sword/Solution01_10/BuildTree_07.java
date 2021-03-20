package com.sword.Solution01_10;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 *
 * @author jianghan
 * @date 2021-03-20 15:52
 */
public class BuildTree_07 {
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < preorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return recursion(0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 计算坐标要用左右子树的数量来计算
     * 如果直接推导左右子树坐标的位置 又难推边界又多
     */
    private TreeNode recursion(int leftPre, int rightPre, int leftIn, int rigthIn) {
        //leftPre > rightPre 等同于 leftIn > rigthIn
        if (leftPre > rightPre) {
            return null;
        }
        //当前递归序列的根节点为前序遍历的第一个元素
        TreeNode currentRoot = new TreeNode(preorder[leftPre]);
        //根节点在中序遍历中的位置
        Integer rootIndex = inMap.get(preorder[leftPre]);
        //这里用节点数量来做 而不是计算节点的索引 可以简化逻辑
        //左子树节点的数量
        int leftTreeCount = rootIndex - leftIn;
        currentRoot.left = recursion(leftPre + 1, leftPre + leftTreeCount, leftIn, rootIndex - leftTreeCount);
        currentRoot.right = recursion(leftPre + leftTreeCount + 1, rightPre, rootIndex + 1, rigthIn);
        return currentRoot;
    }

    public static void main(String[] args) {
        BuildTree_07 buildTree_07 = new BuildTree_07();
        buildTree_07.buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1});
    }
}

