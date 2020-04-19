package com.lp.leetcodeLp.dp;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * /**
 *  * @param {number[]} nums
 *  * @return {boolean}
 *  * 背包问题：看数组中是否存在加起来为sum/2的数.
 *  * 背包容量（V） = sum/2
 *  * 每一个物品只能装一次,如果出现背包中重量等于sum/2则为true else false
 *  * dp[i]表示能否填满容量为i的背包
 *  * 状态转移方程为 dp[i] = dp[i-1] || nums[i]+dp[i-nums[j]]
 *  * 举例:v = sum/2 = 11   nums = [1,5,11,5]  1是true 0 是false
 *  *          0  1  2  3  4  5  6  7  8  9  10  11
 *  *  nums[0] 0  1  0  0  0  0  0  0  0  0   0   0
 *  *  nums[1] 0  1  0  0  0  1  1  0  0  0   0   0
 *  *  nums[2] 0  1  0  0  0  1  1  0  0  0   0   1
 *  *  nums[3] 0  1  0  0  0  1  1  0  0  0   0   1
 *  *
 *  * 所以返回true，因为背包中nums[i]的状态都是由上一行决定的因此可以将二维转化为1维数组从尾部开始
 *   //动态规划
 *         //明确状态：dp[m][n] 考虑是否将第m个数字放入容量为n的背包
 *         boolean[][] dp = new  boolean[n][c+1];
 *
 *         //状态转移方程：dp[m][n] = dp[m-1][n] || dp[m-1][n-nums[m]]
 */
public class CanPartition {


    public boolean canPartition(int[] nums) {
        if (nums.length == 1)   return false;
        if (nums.length == 2)   return  nums[0]==nums[1];
        int sums = sum(nums);
        if (sums % 2 !=0)return false;
        int target = sums / 2;
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        cpmputer(nums , tmp, target , 0,0);
        return false;
    }

    private void cpmputer(int[] nums , List<Integer> tmp, int target, int index ,  int flag){
        for (int num:nums) {
            for (int i = 1; i <= target; i++) {

            }
        }
    }

    /** 经典dp
     * @param nums  数组
     * @param sum   目标和
     * @return  boolean
     *
     * 思路：
     *     设dp[i][j]表示num[0:i]有无子集的和为j，则分两种情况：
     *     （1）丢弃num[i]:dp[i][j] = dp[i-1][j];
     *     （2）纳入num[i]:dp[i][j] = j - num[i] > 0 && dp[i-1][j-num[i]]
     */
    private static boolean dp(int[] nums, int sum) {
        int n = nums.length;
        int half = sum >> 1;
        boolean[][] dp = new boolean[n][half + 1];
        //初始化左上角
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= half; j++) {
                dp[i][j] = dp[i - 1][j] || (j - nums[i] > 0 && dp[i - 1][j - nums[i]]);
            }
        }
        return dp[n - 1][half];
    }


    private int sum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        CanPartition numTrees = new CanPartition();
        int[] A = {1,2,3,4,5,6,7};
        System.out.println(numTrees.canPartition(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
