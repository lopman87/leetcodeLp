package com.lp.leetcodeLp.solution;

public class ClimbStairs {
    public static int climbStairs(int n) {
        if( n ==1 ){
            return 1;
        }
        if (n ==2 ){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(climbStairs(45));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
