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

        Set<String> result = new HashSet<>();

        for (int i = 1; i < s.length() - 1; i++) {
            String tmp = isPal(i,i,i,s);
            result.add(tmp);
        }

        System.out.println(result);
        String rest= "";
        for (String str:result) {
            if (str.length() >= rest.length()){
                rest = str;
            }
        }
        System.out.println(rest);
        return rest;
    }


    private static String isPal(int leftOffset, int rightOffset , int index , String target) {
        if (leftOffset < 0 ){
            return target.substring(0, rightOffset);
        }
        if ( rightOffset > target.length() - 1){
            return target.substring(leftOffset, target.length() - 1);
        }
        if (target.charAt(leftOffset) == target.charAt(rightOffset)){
            return isPal(leftOffset - 1 , rightOffset + 1, index ,target);
        }
        if (target.charAt(index) == target.charAt(rightOffset)){
            return isPal(leftOffset , rightOffset + 1, index ,target);
        }
        return target.substring(leftOffset+1, rightOffset);
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome("cbbd"));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
