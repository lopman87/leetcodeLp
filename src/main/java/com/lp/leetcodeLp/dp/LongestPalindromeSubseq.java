package com.lp.leetcodeLp.dp;

/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }

        return 0;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LongestPalindromeSubseq numTrees = new LongestPalindromeSubseq();
        System.out.println(numTrees.longestPalindromeSubseq("bbbab"));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
