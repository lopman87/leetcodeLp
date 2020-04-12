package com.lp.leetcodeLp.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class NumSquares {


    public int numSquares(int n) {
        int[] tmpArray = new int[n+1];
        tmpArray[0] = 0;
        tmpArray[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (isPerfectSquare(i)){
                tmpArray[i] = 1;
                continue;
            }
            int val = i;
            for (int j=1;j*j<=i;j++) {
                val = Math.min(val, tmpArray[i - j * j] + 1);
            }
            tmpArray[i] = val;
        }
        return tmpArray[n];
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        NumSquares numTrees = new NumSquares();
        System.out.println(numTrees.numSquares(12));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }



    private boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
