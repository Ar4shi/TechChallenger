package com.sword.Solution31_40;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *
 * @author jianghan
 * @date 2021-04-08 21:17
 */
public class VerifyPostorder_33 {
    private int[] postorder;
    private boolean result = true;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        recursion(0, postorder.length - 1);
        return this.result;
    }

    private void recursion(int left, int right) {
        int maxIndex = findMaxIndex(left, right);
        if (maxIndex == -1 || !result) {
            return;
        }
        this.result = judge(left, right, maxIndex);
        recursion(left, maxIndex);
        recursion(maxIndex, right);
    }


    /**
     * 判断左子树的值是否小于根
     * 右子树的值是否大于根
     */
    private boolean judge(int left, int right, int maxIndex) {
        for (int i = left; i <= maxIndex; i++) {
            if (postorder[i] > postorder[maxIndex]) {
                return false;
            }
        }
        for (int i = maxIndex; i <= right; i++) {
            if (postorder[i] < postorder[maxIndex]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 找出数组中第一个比末尾大的数的索引
     * 该索引划分了左右子树
     */
    private int findMaxIndex(int left, int right) {
        //末尾数 即子树的根节点
        int res = -1;
        int last = this.postorder[right];
        if (left >= right) {
            return res;
        }
        for (int i = left; i < right; i++) {
            if (this.postorder[i] > last) {

            }
        }
        return res;
    }

    public static void main(String[] args) {
        VerifyPostorder_33 verifyPostorder_33 = new VerifyPostorder_33();
        verifyPostorder_33.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10});
    }
}
