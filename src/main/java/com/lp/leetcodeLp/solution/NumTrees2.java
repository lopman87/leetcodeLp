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
        return 0;
    }
}
