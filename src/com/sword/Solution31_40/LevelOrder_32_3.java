package com.sword.Solution31_40;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * @author jianghan
 * @date 2021-04-08 20:21
 */
public class LevelOrder_32_3 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //true、从左往右 false、从右往左
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> innerList = new ArrayList<>();
            int round = queue.size();
            for (int i = 0; i < round; i++) {
                TreeNode currentNode = queue.poll();
                innerList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            if (flag) {
                list.add(innerList);
            } else {
                Collections.reverse(innerList);
                list.add(innerList);
            }
            flag = !flag;
        }
        return list;
    }
}
