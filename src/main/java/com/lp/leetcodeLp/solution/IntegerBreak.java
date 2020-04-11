package com.lp.leetcodeLp.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/integer-break/
 */
public class IntegerBreak {

    static Map<Integer , Integer> tmp = new HashMap<>();
    static {
        tmp.put(2,1);
        tmp.put(1,1);
        tmp.put(3,2);
        tmp.put(4,4);
        tmp.put(5,6);
        tmp.put(6,9);
        tmp.put(7,12);
        tmp.put(8,18);
    }
    public int doIntegerBreak(int n) {
        if (tmp.containsKey(n)){
            return tmp.get(n);
        }
        int max = 0;
        for (int i = 1; i <= n/2; i++) {
            int res1 = i * (n-i);
            int res2 = i * doIntegerBreak(n-i);
            int tmpMax = res1 > res2 ? res1:res2;
            max = tmpMax > max ? tmpMax : max;
        }
        tmp.put(n , max);
        return max;
    }
    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IntegerBreak numTrees = new IntegerBreak();
        System.out.println(numTrees.doIntegerBreak(9));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
