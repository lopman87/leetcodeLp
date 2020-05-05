package com.lp.leetcodeLp.array;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }
        if (nums.length == 1){
            return ""+nums[0];
        }
        res = new StringBuilder();
        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).forEach(x -> res.append(x));
        return res.charAt(0) == '0' ? "0" : res.toString();
    }

    private StringBuilder res;



    public static void main(String[] args){

        LargestNumber cache = new LargestNumber();
        int[] nums = {9,61};
        System.out.println(cache.largestNumber(nums));
    }
}
