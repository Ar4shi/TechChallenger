package com.interview.hard;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * 给定一个由不同节点组成的二叉搜索树 root，输出所有可能生成此树的数组。
 * <p>
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: [[2,1,3],[2,3,1]]
 * 解释: 数组 [2,1,3]、[2,3,1] 均可以通过从左向右遍历元素插入树中形成以下二叉搜索树
 * 2
 * / \
 * 1   3
 * <p>
 * 示例 2:
 * 输入: root = [4,1,null,null,3,2]
 * 输出: [[4,1,3,2]]
 * 提示：
 * <p>
 * 二叉搜索树中的节点数在 [0, 1000] 的范围内
 * 1 <= 节点值 <= 10^6
 * 用例保证符合要求的数组数量不超过 5000
 */
public class BSTSequencesLCCI {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (Objects.isNull(root)) {
            result.add(new ArrayList<>());
            return result;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root);
        dfs(new ArrayList<>(), treeNodeList, root);
        return result;
    }

    private void dfs(List<Integer> list, List<TreeNode> treeNodeList, TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }
        // 不想回溯列表已添加的元素，所以每次都拷贝一份
        List<Integer> listCopy = new ArrayList<>(list);
        List<TreeNode> treeNodeListCopy = new ArrayList<>(treeNodeList);
        listCopy.add(currentNode.val);
        treeNodeListCopy.remove(currentNode);
        if (Objects.nonNull(currentNode.left)) {
            treeNodeListCopy.add(currentNode.left);
        }
        if (Objects.nonNull(currentNode.right)) {
            treeNodeListCopy.add(currentNode.right);
        }
        for (TreeNode treeNode : treeNodeListCopy) {
            dfs(listCopy, treeNodeListCopy, treeNode);
        }
        if (treeNodeListCopy.isEmpty()) {
            result.add(new ArrayList<>(listCopy));
        }
    }

}
