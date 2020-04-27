package com.lp.leetcodeLp.dp;

import java.util.*;

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
        if (s.length() == 2){
            return s.charAt(0) == s.charAt(1) ? 2 : 1;
        }
        TreeSet<String> result = new TreeSet<>(Comparator.comparingInt(String::length).reversed());
        for (int i = 0; i < s.length()-1 ; i++) {
            StringBuilder  stringBuilder = new StringBuilder();
            buildPalindrome(i-1,i+1,s,stringBuilder);
            result.add(stringBuilder.toString());
            if (s.charAt(i) == s.charAt(i+1)){
                StringBuilder stringBuilder2 = new StringBuilder();
                buildPalindrome(i-1,i+2,s,stringBuilder2);
                result.add(stringBuilder2.toString());
            }
        }
        String rest= result.first();
        System.out.println(rest);
        return rest.length();
    }
    private void buildPalindrome(int leftOffset, int rightOffset ,  String target , StringBuilder result){
        if (leftOffset < 0 ){
           String res1 = target.substring(0, rightOffset >= target.length()  ? target.length()  : rightOffset);
            result.append(res1);
            return;
        }
        if (rightOffset > target.length() - 1){
            String res2 =  target.substring(leftOffset+1);
            result.append(res2);
            return;
        }
        char left = target.charAt(leftOffset);
        char right = target.charAt(rightOffset);
        if (left == right){
            buildPalindrome(leftOffset-1, rightOffset+1,target,result);
        }else{
            while (rightOffset < target.length()){
                if (target.charAt(rightOffset) == left){
                    break;
                }
                rightOffset++;
            }
            buildPalindrome(leftOffset-1, rightOffset,target,result);
        }
    }



    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LongestPalindromeSubseq numTrees = new LongestPalindromeSubseq();
        System.out.println(numTrees.longestPalindromeSubseq("bbbab"));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
