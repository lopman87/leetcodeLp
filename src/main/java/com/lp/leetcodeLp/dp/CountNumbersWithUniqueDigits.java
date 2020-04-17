package com.lp.leetcodeLp.dp;

/**
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 *
 *
 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。

 示例:

 输入: 2
 输出: 91
 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 *
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 0;
        if (n==1) return 10;
        if (n==2) return 91;
        double range = Math.pow(10,n);
        Double newData = new Double(range);
        int value = newData.intValue();
        return 0;
    }
}
