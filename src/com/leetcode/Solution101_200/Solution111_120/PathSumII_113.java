package com.leetcode.Solution101_200.Solution111_120;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 *
 * @author jianghan
 * @date 2020-09-26 00:53
 */
public class PathSumII_113 {
    List<List<Integer>> result = new ArrayList<>();
    int remain;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.remain = sum;
        DFS(root, new ArrayList<>());
        return result;
    }

    private void DFS(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            remain -= node.val;
            list.add(node.val);
            if (remain == 0) {
                result.add(new ArrayList<>(list));
            }
            //符合条件的叶子节点记录后需要回溯
            remain += node.val;
            list.remove(list.size() - 1);
            return;
        }
        list.add(node.val);
        remain -= node.val;
        DFS(node.left, list);
        DFS(node.right, list);
        //采用先序遍历,入list存储的节点需要回溯
        remain += list.get(list.size() - 1);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII_113 pathSumII_113 = new PathSumII_113();
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(13);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(2);
        TreeNode h = new TreeNode(5);
        TreeNode i = new TreeNode(1);
        root.left = a;
        root.right = b;
        a.left = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;
        pathSumII_113.pathSum(root, 22);
    }
}
