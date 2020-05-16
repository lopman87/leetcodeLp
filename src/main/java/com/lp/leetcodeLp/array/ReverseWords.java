package com.lp.leetcodeLp.array;

import java.util.Arrays;

public class ReverseWords {


    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || !s.contains(" ")){
            return s;
        }
        String[] arrayOfString = s.split("\\s+");
        if (arrayOfString.length % 2 == 0){
            for (int i = arrayOfString.length-1; i >= arrayOfString.length/2 ; i--) {
                String tmp = arrayOfString[i];
                arrayOfString[i] = arrayOfString[ arrayOfString.length - i -1];
                arrayOfString[ arrayOfString.length - i -1] = tmp;
            }
        }else{
            for (int i = 0; i < arrayOfString.length/2; i++) {
                String tmp = arrayOfString[i];
                arrayOfString[i] = arrayOfString[ arrayOfString.length - i -1];
                arrayOfString[ arrayOfString.length - i -1] = tmp;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String ss : arrayOfString) {
            stringBuilder.append(ss).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public int search(int[] nums, int target) {
       return Arrays.binarySearch(nums, target);
    }

    public static void main(String[] args){
        ReverseWords cache = new ReverseWords();

        System.out.println(cache.reverseWords("sca dsd  dcsds aaa"));
    }
}
