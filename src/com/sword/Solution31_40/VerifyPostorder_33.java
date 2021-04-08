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
        int rootIndex = findRootIndex(left, right);
        if (rootIndex == -1 || !result) {
            return;
        }
        this.result = judge(left, right, rootIndex);
        if (rootIndex == -2) {
            //没有比末尾大的树 即都是他的左子树
            recursion(left, right - 1);
        }else {
            recursion(left, rootIndex - 1);
            recursion(rootIndex, right - 1);
        }
    }


    /**
     * 判断左子树的值是否小于根
     * 右子树的值是否大于根
     */
    private boolean judge(int left, int right, int rootIndex) {
        //末尾数 即子树的根节点
        int last = this.postorder[right];
        //没有比末尾大的树 即都是他的左子树
        if (rootIndex == -2) {
            for (int i = left; i < right; i++) {
                if (postorder[i] > last) {
                    return false;
                }
            }
        } else {
            for (int i = left; i < rootIndex; i++) {
                if (postorder[i] > last) {
                    return false;
                }
            }
            for (int i = rootIndex; i < right; i++) {
                if (postorder[i] < last) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 找出数组中第一个比末尾大的数的索引
     * 该索引划分了左右子树
     */
    private int findRootIndex(int left, int right) {
        int res = -1;
        if (left >= right || left < 0) {
            return res;
        }
        //末尾数 即子树的根节点
        int last = this.postorder[right];
        for (int i = left; i < right; i++) {
            if (this.postorder[i] > last) {
                return i;
            }
        }
        //没有比末尾大的树 即都是他的左子树
        return -2;
    }

    public static void main(String[] args) {
        VerifyPostorder_33 verifyPostorder_33 = new VerifyPostorder_33();
        System.out.println(verifyPostorder_33.verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
    }
}
