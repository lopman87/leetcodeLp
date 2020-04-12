package com.lp.leetcodeLp.solution;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        return 0;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LengthOfLIS numTrees = new LengthOfLIS();
        int[] A = {10,9,2,5,3,7,101,18};
        System.out.println(numTrees.lengthOfLIS(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
