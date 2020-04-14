package com.lp.leetcodeLp.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 *
 *
 */
public class MaxProduct {

    public int maxProduct1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
            int preMax = dpMax;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;

    }

    public int maxProduct(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                int flag = bigOne(nums,j,i);
                if (flag > tmp[i]){
                    tmp[i] = flag;
                }
            }
        }
        return max(tmp);
    }

    public int max(int[] nums){
        int flag = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > flag){
                flag = nums[i];
            }
        }
        return flag;
    }

    public int bigOne(int[] nums , int begin , int end){
        int res = 1;
        for (int i = begin; i <= end; i++) {
            if (nums[i] == 1){
                continue;
            }else {
                res = nums[i] * res;
            }
        }
        return res;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        MaxProduct numTrees = new MaxProduct();
        int[] A = {-3,2,-4};
        System.out.println(numTrees.maxProduct(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
