package com.lp.leetcodeLp.solution;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome("babad"));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
