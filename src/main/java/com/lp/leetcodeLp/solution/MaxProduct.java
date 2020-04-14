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
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                int flag = max(nums,j,i);
                if (flag > tmp[i]){
                    tmp[i] = flag;
                }
            }
        }
        Arrays.sort(tmp);
        return tmp[tmp.length-1];
    }

    public int max(int[] nums , int begin , int end){
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
