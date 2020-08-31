package com.lp.leetcodeLp.dp;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToChange {


    public int waysToChange(int n) {
        int[] coins = new int[]{1, 2, 5};
        return 0;
    }

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        //初始化dp数据
        int[] dp = new int[amount+1];
        for(int i = 0; i<dp.length; i++) dp[i] = 99999;
        dp[0] = 0;
        for (int coin:coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i >= coin){
                    dp[i] = Math.min(dp[i - coin] +1 , dp[i] );
                }
            }
        }
        return dp[amount] == 99999 ? -1: dp[amount];
    }



    public static void main(String args[]){
        WaysToChange numTrees = new WaysToChange();
        int[] coins = new int[]{1, 2, 5};
        int[] coins1 = new int[]{2};
        System.out.println(numTrees.coinChange(coins,3));
    }
}
