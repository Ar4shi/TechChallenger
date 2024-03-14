package com.interview.medium;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepth {

    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<List<TreeNode>> treeNodesList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            int count = queue.size();
            while (count-- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            treeNodesList.add(list);
        }
        ListNode[] result = new ListNode[treeNodesList.size()];
        for (int i = 0; i < treeNodesList.size(); i++) {
            List<TreeNode> treeNodes = treeNodesList.get(i);
            ListNode virtualHeadNode = new ListNode(0);
            ListNode currentNode = virtualHeadNode;
            for (int j = 0; j < treeNodes.size(); j++) {
                ListNode node = new ListNode(treeNodes.get(j).val);
                currentNode.next = node;
                currentNode = currentNode.next;
            }
            result[i] = virtualHeadNode.next;
        }
        return result;
    }
}
