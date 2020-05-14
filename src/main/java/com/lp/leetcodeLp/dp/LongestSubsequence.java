package com.lp.leetcodeLp.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {

        int[] dp = new int[arr.length];
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                    res = Math.max(res , dp[i]);
                }
            }
        }
        return res+1;
    }

    public int longestSubsequence1(int[] arr, int difference) {
        int res = 1;
        Map<Integer, Integer> times = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = times.getOrDefault(arr[i] - difference, 0) + 1;
            times.put(arr[i], temp);
            res = Math.max(res ,temp);
        }
        return res;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LongestSubsequence numTrees = new LongestSubsequence();
        int[] A = {1,3,5,7,9};
        System.out.println(numTrees.longestSubsequence1(A ,2));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
