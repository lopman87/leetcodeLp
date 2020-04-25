package com.lp.leetcodeLp.dp;

public class IsMatchWildcard1 {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)return false;
        return false;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IsMatchWildcard1 numTrees = new IsMatchWildcard1();
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        String p ="a*******b";
        System.out.println(numTrees.isMatch(s,p));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
