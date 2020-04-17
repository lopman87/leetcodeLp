package com.lp.leetcodeLp.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 */
public class CountBits {

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            String binaryString = Integer.toBinaryString(i);
            long java8 = binaryString.chars().filter(ch -> ch =='1').count();
            result[i] = (int) java8;
        }
        return result;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        CountBits numTrees = new CountBits();
        System.out.println(Arrays.toString(numTrees.countBits(5)));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
