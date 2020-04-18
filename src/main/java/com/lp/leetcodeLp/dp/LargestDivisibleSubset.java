package com.lp.leetcodeLp.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 */
public class LargestDivisibleSubset {


    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();

        return result;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LargestDivisibleSubset numTrees = new LargestDivisibleSubset();
        int[] A = {5,0,0};
        System.out.println(numTrees.largestDivisibleSubset(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
