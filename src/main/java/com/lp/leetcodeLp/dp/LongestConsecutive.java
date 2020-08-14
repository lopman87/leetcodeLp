package com.lp.leetcodeLp.dp;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {

        if (nums == null)return 0;
        if (nums.length == 0)return 0;
        if (nums.length == 1)return 1;
        if (nums.length == 2){
            if (Math.abs( nums[0] - nums[1]) == 1)return 2;
            return 1;
        }

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));


        nums = Arrays.stream(nums).distinct().toArray();


        System.out.println(Arrays.toString(nums));

        int max = 1;
        int realMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs( nums[i] - nums[i-1]) <= 1){
                max++;
                realMax = Math.max(realMax , max);
            }else{
                max = 1;
            }
        }
        return realMax;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        int[] aaa  ={1,2,0,1};
        LongestConsecutive numTrees = new LongestConsecutive();
        System.out.println(numTrees.longestConsecutive(aaa));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
