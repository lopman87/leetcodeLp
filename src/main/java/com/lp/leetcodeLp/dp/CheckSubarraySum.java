package com.lp.leetcodeLp.dp;

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
            int sums = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sums +=  nums[j];
                if (k == 0){
                    if (sums == 0){
                        return true;
                    }else{
                        sums = 0;
                        break;
                    }
                }else if(sums % k == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkSubarraySum1(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            int innerVal = nums[i];
            for (int j = 0; j < i; j++) {
                innerVal += nums[j];
                if(innerVal % k == 0){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        CheckSubarraySum numTrees = new CheckSubarraySum();
        int[] A = {23,2,6,4,7};

        System.out.println(numTrees.checkSubarraySum1(A,88));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
