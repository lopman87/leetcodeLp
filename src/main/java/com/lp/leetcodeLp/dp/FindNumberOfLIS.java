package com.lp.leetcodeLp.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i] , dp[j]+1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
    //最长的上升子序列是 [2,3,7,101]，它的长度是 4

    public static void main(String args[]){
        FindNumberOfLIS numTrees = new FindNumberOfLIS();
        int[] A = {10,9,2,5,3,7,101,18};
        System.out.println(numTrees.findNumberOfLIS(A ));
    }
}
