package com.leetcode.Solution201_300.Solution251__260;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * @author jianghan
 * @date 2020-09-04 00:46
 */
public class BinaryTreePaths_257 {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        recursion(root, new ArrayList<>());
        return result;
    }

    /**
     * 由于list是引用类型,所以每次递归之后需要回溯
     */
    private void recursion(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            String res = "";
            for (int i = 0; i < list.size(); i++) {
                res += list.get(i) + "->";
            }
            result.add(res.substring(0, res.length() - 2));
            return;
        }
        if (root.left != null) {
            recursion(root.left, list);
            //回溯点1
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            recursion(root.right, list);
            //回溯点2
            list.remove(list.size() - 1);
        }
    }

    /**
     * String在java中是引用副本,所以不需要回溯
     */
    private void recursion(TreeNode root, String str) {
        str += root.val + "->";
        if (root.left == null && root.right == null) {
            result.add(str.substring(0, str.length() - 2));
            return;
        }
        if (root.left != null) {
            recursion(root.left, str);
        }
        if (root.right != null) {
            recursion(root.right, str);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.right = c;
        BinaryTreePaths_257 binaryTreePaths_257 = new BinaryTreePaths_257();
        binaryTreePaths_257.binaryTreePaths(root);
    }
}
