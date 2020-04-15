package com.lp.leetcodeLp.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    static Map<Integer, Integer> recored  = new HashMap<>();

    public static int climbStairs(int n) {
        if( n ==1 ){
            return 1;
        }
        if (n ==2 ){
            return 2;
        }
        Integer old = recored.get(n);
        if (old != null){
            return old;
        }
        int result = climbStairs(n-1) + climbStairs(n-2);
        recored.put(n,result);
        return result;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(climbStairs(45));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
