package com.interview.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * 注意：此题相对书上原题略有改动。
 * <p>
 * 示例1:
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 * <p>
 * 示例2:
 * 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 * 输出：false
 * <p>
 * 提示：
 * 树的节点数目范围为[0, 20000]。
 */
public class CheckSubTreeLCCI {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        // 边界判断
        if (Objects.isNull(t1)) {
            if (Objects.isNull(t2)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (Objects.isNull(t2)) {
                return true;
            }
        }
        // 找到所有值为t2.val的节点
        List<TreeNode> nodeList = findNodeList(t1, t2);
        for (TreeNode treeNode : nodeList) {
            if (isSameTree(treeNode, t2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (Objects.isNull(t1) && Objects.isNull(t2)) {
            return true;
        }
        if (Objects.isNull(t1) || Objects.isNull(t2)) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    private List<TreeNode> findNodeList(TreeNode t1, TreeNode t2) {
        int targetValue = t2.val;
        List<TreeNode> list = new ArrayList<>();
        dfs(list, t1, targetValue);
        return list;
    }

    private void dfs(List<TreeNode> list, TreeNode node, int targetValue) {
        if (Objects.isNull(node)) {
            return;
        }
        if (node.val == targetValue) {
            list.add(node);
        }
        dfs(list, node.left, targetValue);
        dfs(list, node.right, targetValue);
    }
}
