package com.lp.leetcodeLp.solution;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees2 {
    public int numTrees(int n) {
        if (n <= 2){
            return n;
        }
        if ( n == 3){
            return 5;
        }
        if ( n == 4){
            return 14;
        }
        return getAns(1, n);
    }
    private int getAns(int start, int end) {
        int ans = 0;
        //此时没有数字，只有一个数字,返回 1
        if (start >= end) {
            return 1;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            int leftTreesNum = getAns(start, i - 1);
            //得到所有可能的右子树
            int rightTreesNum  = getAns(i + 1, end);
            //左子树右子树两两组合
            ans+=leftTreesNum * rightTreesNum;
        }
        return ans;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        NumTrees2 numTrees = new NumTrees2();
        System.out.println(numTrees.numTrees(4));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }

}
