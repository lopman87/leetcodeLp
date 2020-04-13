package com.lp.leetcodeLp.solution;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 *
 *
 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

 示例 1:

 输入: [23,2,4,6,7], k = 6
 输出: True
 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 示例 2:

 输入: [23,2,6,4,7], k = 6
 输出: True
 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 */
public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length-1; i++) {
            int sums = 0;
            for (int j = i+1; j < nums.length; j++) {
                sums += nums[i] + nums[j];
                if (k == 0){
                    if (sums == 0){
                        return true;
                    }else{
                        return false;
                    }
                }else if(sums % k == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        long start = System.currentTimeMillis();
        CheckSubarraySum numTrees = new CheckSubarraySum();
        int[] A = {5,0,0};

        System.out.println(numTrees.checkSubarraySum(A,0));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
