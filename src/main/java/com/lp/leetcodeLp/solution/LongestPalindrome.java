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
        for (int i = 1; i < s.length()-1 ; i++) {
            String tmp = buildPal(i,i,i,s);
            result.add(tmp);
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

    private static String buildPal(int leftOffset, int rightOffset , int index , String target) {
        if (leftOffset < 0 ){
            return target.substring(0, rightOffset > target.length() - 1 ? target.length() - 1 : rightOffset);
        }
        if ( rightOffset > target.length() - 1){
            return target.substring(leftOffset+1);
        }

        if ( isPal(target.substring(leftOffset, rightOffset+1)) ){
            buildPal(--leftOffset, ++rightOffset , index, target);
        }
        return "";
    }

    private static boolean isPal(String tmp){
        int flag = tmp.length()/2;
        int index = 0;
        while (index < flag){
            if ( tmp.charAt(index) != tmp.charAt(tmp.length() - 1 - index) ){
                break;
            }
            index ++;
        }
        return index == flag;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome("ccdd"));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
