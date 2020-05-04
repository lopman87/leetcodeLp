package com.lp.leetcodeLp.array;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }
        if (nums.length == 1){
            return ""+nums[0];
        }
        return null;
    }

    public static void main(String[] args){

        LargestNumber cache = new LargestNumber();
        int[] nums = {9,61};
        System.out.println(cache.largestNumber(nums));
    }
}
