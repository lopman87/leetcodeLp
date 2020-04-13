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

        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }

        List<List<Integer>> tmpAll = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            List<Integer> tmpArr = new ArrayList<>();
            tmpArr.add(nums[i] );
            doLengthOfLIS(nums[i] , i  , nums,tmpArr);
            tmpAll.add(tmpArr);
        }
        System.out.println(tmpAll);
        return 0;
    }

    public void doLengthOfLIS(int flag , int index, int[] nums ,List<Integer> res) {
        int tmpFlag = flag;
        for (int i = index + 1; i < nums.length; i++) {
            if ( nums[i] > tmpFlag){
                tmpFlag = nums[i];
                res.add(nums[i]);
            }else{
                doLengthOfLIS(tmpFlag , ++index,  nums , res);
            }
        }
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LengthOfLIS numTrees = new LengthOfLIS();
        //int[] A = {10,9,2,5,3,7,101,18};
        int[] A = {10,9,2,5,3,4};

        System.out.println(numTrees.lengthOfLIS(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
