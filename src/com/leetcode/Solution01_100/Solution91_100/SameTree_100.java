package com.leetcode.Solution01_100.Solution91_100;

import com.leetcode.TreeNode;

import java.util.Stack;

/**
 * 相同的树
 *
 * @author jianghanh
 * @date 2020-03-05 10:26
 */
public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return iterationSameTress(p, q);
    }

    /**
     * 方案一：
     * 递归比较
     * 实质就是DFS
     *
     * @return
     */
    private boolean recursionSameTress(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) {
            //比较左子树
            boolean leftFlag = recursionSameTress(p.left, q.left);
            //比较右子树
            boolean rightFlag = recursionSameTress(p.right, q.right);
            return leftFlag && rightFlag;
        } else {
            return false;
        }
    }

    /**
     * 方案二：
     * 迭代比较
     * 实质也是DFS
     *
     * @return
     */
    private boolean iterationSameTress(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        while ((p != null || pStack.size() > 0) && (q != null || qStack.size() > 0)) {
            if (p != null && q != null) {
                pStack.add(p);
                p = p.left;
                qStack.add(q);
                q = q.left;
                /*此处判断树结构,若树的结果不同,也不是相同的树*/
                if(p==null&&q!=null||p!=null&&q==null){
                    return false;
                }
            } else {
                TreeNode pCurNode = pStack.pop();
                TreeNode qCurNode = qStack.pop();
                /*深度遍历到最底层叶子节点再开启比较*/
                if (pCurNode.val != qCurNode.val) {
                    return false;
                }
                p = pCurNode.right;
                q = qCurNode.right;
                /*此处判断树结构,若树的结果不同,也不是相同的树*/
                if(p!=null&&q==null||p==null&&q!=null){
                    return false;
                }
                if(p!=null){
                    pStack.add(p);
                }
                if(q!=null){
                    qStack.add(q);
                }
            }
        }
        return p==null&&q==null;
    }

    public static void main(String[] args) {
        SameTree_100 SameTree_100 = new SameTree_100();

        TreeNode p = new TreeNode(2);
        p.left = null;
        p.right = new TreeNode(4);
        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(3);
        q.right = new TreeNode(4);
        System.out.println(SameTree_100.isSameTree(p,q));
    }
}
