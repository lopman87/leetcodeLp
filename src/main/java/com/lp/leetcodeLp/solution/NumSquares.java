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
    static Map<Integer , Integer> tmp = new HashMap<>();
    static {
        tmp.put(1,1);
    }
    public int numSquares(int n) {
        if (tmp.containsKey(n)){
            return tmp.get(n);
        }
        return 0;
    }


    

    /**
     * 获取小于N的所有完全平方数
     * @param num
     * @return
     */
    private List<Integer> getAllSquare(int num){
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (isPerfectSquare(i)){
                tmp.add(i);
            }
        }
        return tmp;
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
