package com.lp.leetcodeLp.dp;

/**
 * 最大公共子字符串
 */
public class LcssProblem {
    public void Lcss(char str1[],char str2[]){
        int dp[][]=new int[str1.length][str2.length];
        //对dp矩阵的第一列赋值
        for(int i=0;i<str1.length;i++)
        {
            if(str2[0]==str1[i])
                dp[i][0]=1;
            else {
                dp[i][0]=0;
            }
        }
        //对dp矩阵的第一行赋值
        for(int j=0;j<str2.length;j++)
        {
            if(str1[0]==str2[j])
                dp[0][j]=1;
            else {
                dp[0][j]=0;
            }
        }
        for(int i=1;i<str1.length;i++)
            for(int j=1;j<str2.length;j++)
            {
                if(str1[i]==str2[j])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=0;
                }
            }
        int max=dp[0][0];
        for(int i=0;i<str1.length;i++)
            for(int j=0;j<str2.length;j++)
            {
                max=Math.max(max,dp[i][j]);
            }
        System.out.println(max);
    }
}


