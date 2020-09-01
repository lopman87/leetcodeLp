package com.lp.leetcodeLp.dp;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int word11 = word1.length();
        int word22 = word2.length();
        int[][] dp = new int[word11 +1][word22+1];
        // 第一行
        for (int j = 1; j <= word22; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= word11; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min( dp[i-1][j] +1 , Math.min( dp[i][j-1] +1 ,dp[i-1][j-1] +1 ) );
            }
        }

        return dp[word11][word22];
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        MinDistance numTrees = new MinDistance();
        System.out.println(numTrees.minDistance("intention","execution"));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
