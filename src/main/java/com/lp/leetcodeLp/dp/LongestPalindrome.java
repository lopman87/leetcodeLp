package com.lp.leetcodeLp.dp;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        if (s.length() == 2){
            if (s.charAt(0) == s.charAt(1)){
                return s;
            }else{
                return s.charAt(0)+"";
            }
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length()-1 ; i++) {
            String tmp = buildPal(i-1,i+1,s);
            result.add(tmp);
            if (s.charAt(i) == s.charAt(i+1)){
                String tmp2 = buildPal(i-1,i+2,s);
                result.add(tmp2);
            }
        }

        System.out.println(result);
        String rest= "";
        for (String str:result) {
            if (str.length() >= rest.length()){
                rest = str;
            }
        }
        return rest;
    }

    private static String buildPal(int leftOffset, int rightOffset ,  String target) {
        if (leftOffset < 0 ){
            return target.substring(0, rightOffset >= target.length()  ? target.length()  : rightOffset);
        }
        if ( rightOffset > target.length() - 1){
            return target.substring(leftOffset+1);
        }

        if (target.charAt(leftOffset) == target.charAt(rightOffset)){
            return buildPal(--leftOffset, ++rightOffset , target);
        }
        return target.substring(++leftOffset, rightOffset);
    }
    public static String longestPalindrome1(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] sArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        boolean[][] paArray = new boolean[sArray.length][sArray.length];
        for (int i = 0; i < sArray.length; i++) {
            paArray[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (sArray[i] != sArray[j]) {
                    paArray[i][j] = false;
                } else {
                    if (j - i < 3) {
                        paArray[i][j] = true;
                    } else {
                        paArray[i][j] = paArray[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (paArray[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome1("cbbd"));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
