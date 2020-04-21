package com.lp.leetcodeLp.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob {
    /**
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[1], nums[0]);
        }
        if (nums.length == 3){
            return Math.max(nums[1], nums[0] + nums[2]);
        }
        if (nums.length == 4){
            return Math.max(nums[0] + nums[3], Math.max(nums[0] + nums[2], nums[1] + nums[3]));
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxVal = nums[i];
            for (int j = 0; j < i - 1; j=j+2) {
                maxVal = maxVal + nums[j];
            }
            total = Math.max(total , maxVal);
        }
        return total;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        Rob numTrees = new Rob();
        int[] A = {1,3,1,3,100};
        System.out.println(numTrees.rob(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
