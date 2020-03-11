package com.leetcode.Solution01_100.Solution91_100;

/**
 * 不同的二叉搜索树
 *
 * @author jianghanh
 * @date 2020-03-04 14:51
 */
public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {

        /**
         * res[n]用于存储以 1 ... n 为节点组成的二叉搜索树的种数量
         * res[n] = rootCount[1]+rootCount[2]+........+rootCount[n];
         * rootCount[i]当以i为根节点时,可以构成的树的种数为左子树的种数*右子树的种数，即
         * rootCount[i] =  res[i-1]*res[n-i]
         */
        int[] res = new int[n + 1];
        //空树也算一种
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            for(int j = 1;j<=i;j++){
                res[i] += res[j-1]*res[i-j];
            }
        }

        return res[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees_96 uniqueBinarySearchTrees_96 = new UniqueBinarySearchTrees_96();
        System.out.println(uniqueBinarySearchTrees_96.numTrees(3));
    }
}
