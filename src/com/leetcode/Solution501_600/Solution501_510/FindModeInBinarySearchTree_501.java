package com.leetcode.Solution501_600.Solution501_510;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * 二叉搜索树中的众数
 *
 * @author jianghan
 * @date 2020-09-24 00:08
 */
public class FindModeInBinarySearchTree_501 {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        BFS(root);
        map.forEach((k, v) -> {
            if (v == max) {
                list.add(k);
            }
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void DFS(TreeNode node) {
        if (node == null) {
            return;
        }
        if (map.containsKey(node.val)) {
            map.put(node.val, map.get(node.val) + 1);
        } else {
            map.put(node.val, 1);
        }
        max = Math.max(map.get(node.val), max);
        DFS(node.left);
        DFS(node.right);
    }

    private void BFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(node!=null){
            queue.add(node);
        }
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if (map.containsKey(currentNode.val)) {
                map.put(currentNode.val, map.get(currentNode.val) + 1);
            } else {
                map.put(currentNode.val, 1);
            }
            max = Math.max(map.get(currentNode.val), max);
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
    }
}
