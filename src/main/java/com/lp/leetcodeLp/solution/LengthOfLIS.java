package com.lp.leetcodeLp.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LengthOfLIS numTrees = new LengthOfLIS();
        int[] A = {10,9,2,5,3,7,101,18};
        //int[] A = {10,9,2,5,3,4};

        System.out.println(numTrees.lengthOfLIS(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
