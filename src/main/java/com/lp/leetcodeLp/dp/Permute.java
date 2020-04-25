package com.lp.leetcodeLp.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length ==0){
            return lists;
        }
        if (nums.length==1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
        Arrays.sort(nums);
        if (nums.length==2){
            List<Integer> list1 = new ArrayList<>();
            list1.add(nums[0]);list1.add(nums[1]);
            lists.add(list1);
            List<Integer> list2 = new ArrayList<>();
            list2.add(nums[1]);list2.add(nums[0]);
            lists.add(list2);
            return lists;
        }

        return lists;
    }

    private void tryPermute(List<List<Integer>> lists , int number){
        List<Integer> lastArray = lists.get(lists.size()-1);
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        Permute numTrees = new Permute();
        int[] p ={1,2,3};
        System.out.println(numTrees.permute(p));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
