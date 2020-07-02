package com.lp.leetcodeLp.dp;

import java.util.Arrays;

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
        int[] length = new int[nums.length];
        length[0] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    length[i] = Math.max(length[i] , length[j]+1);
                }else {

                }
                max = Math.max(length[i]  , max);
            }
        }
        System.out.println(Arrays.toString(length));
        return max;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LengthOfLIS numTrees = new LengthOfLIS();
        int[] A = {2,2};
        System.out.println(numTrees.lengthOfLIS(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
