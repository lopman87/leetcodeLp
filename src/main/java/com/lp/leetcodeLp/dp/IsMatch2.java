package com.lp.leetcodeLp.dp;

public class IsMatch2 {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)return false;
        return false;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IsMatch2 numTrees = new IsMatch2();
        String s = "aaa";
        String p = "a*a";
        System.out.println(numTrees.isMatch(s,p));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
