package com.lp.leetcodeLp.solution;

import java.util.ArrayList;
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
        List<List<Integer>> tmpAll = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            List<Integer> tmp = new ArrayList<>();
            doLengthOfLIS(nums[i] , i + 1 , nums, tmp);
            tmpAll.add(tmp);
        }
        System.out.println(tmpAll);
        return 0;
    }

    public void doLengthOfLIS(int flag , int index, int[] nums, List<Integer> tmp) {
        for (int i = index; i < nums.length; i++) {
            if ( nums[i] > flag){
                tmp.add(nums[i]);
                doLengthOfLIS(nums[i] , i +1 , nums,tmp);
            }
        }
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
