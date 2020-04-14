package com.lp.leetcodeLp.solution;

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
        return 0;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        MaxProduct numTrees = new MaxProduct();
        int[] A = {5,0,0};
        System.out.println(numTrees.maxProduct(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
