package com.lp.leetcodeLp.dp;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty() || "".equals(s))return result;
        char[] tmpArray = s.toCharArray();
        boolean[][] dp = new boolean[tmpArray.length][tmpArray.length];
        dp[0][0]=true;
        for (int i = 1; i < tmpArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if(tmpArray[i] == tmpArray[j]){
                    dp[i][j]  = dp[i-1][j+1];
                }else{
                    dp[i][j]  = dp[i][j+1] || dp[i-1][j];
                }
            }
        }
        System.out.println(dp[0][3]);
        return result;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        int size = s.length()+1;
        int[][] dp = new int[size][size];
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if(s.charAt(i-1) == reverse.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println( dp[size-1][size-1]);

        return s;
    }


    public boolean isPalindrome(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        int size = s.length()+1;
        boolean[][] dp = new boolean[size][size];
        dp[0][0] = true;
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if(s.charAt(i-1) == reverse.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return ( dp[size-1][size-1]);
    }


    public static void main(String[] args){

        Partition cache = new Partition();

        System.out.println(cache.isPalindrome("adssfa"));

    }
}
