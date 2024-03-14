package com.leetcode.Solution301_400.Solution331_340;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 III
 *
 * @author jianghan
 * @date 2021-01-28 01:09
 */
public class HouseRobberIII_337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, int[]> map = new HashMap<>();
        dfs(root.left, map);
        dfs(root.right, map);
        //root节点最后进行合并
        int[] result = new int[2];
        //根节点不偷 子节点可以偷也可以不偷 取最大值
        int[] leftResult = map.get(root.left) == null ? new int[]{0, 0} : map.get(root.left);
        int[] rightResult = map.get(root.right) == null ? new int[]{0, 0} : map.get(root.right);
        result[0] = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);
        //根节点偷 子节点一定不能偷
        result[1] = leftResult[0] + rightResult[0] + root.val;
        return Math.max(result[0], result[1]);
    }

    /**
     * 因为父节点的最大值由其孩子节点决定
     * 所以按后序遍历二叉树
     */
    private void dfs(TreeNode currentNode, Map<TreeNode, int[]> map) {
        if (currentNode == null) {
            return;
        }
        dfs(currentNode.left, map);
        dfs(currentNode.right, map);
        //0代表不偷 1代表偷
        int[] currentResult = new int[2];
        int[] left = map.get(currentNode.left) == null ? new int[]{0, 0} : map.get(currentNode.left);
        int[] right = map.get(currentNode.right) == null ? new int[]{0, 0} : map.get(currentNode.right);
        //本节点不偷 子节点可以偷也可以不偷 取最大值
        currentResult[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //本节点偷 子节点一定不能偷
        currentResult[1] = left[0] + right[0] + currentNode.val;
        map.put(currentNode, currentResult);
    }

    public static void main(String[] args) {
        HouseRobberIII_337 houseRobberIII_337 = new HouseRobberIII_337();
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(1);
        root.left = a;
        root.right = b;
        a.right = c;
        b.right = d;
        houseRobberIII_337.rob(root);
    }
}
