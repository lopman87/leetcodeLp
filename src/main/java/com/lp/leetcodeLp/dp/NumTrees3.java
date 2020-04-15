package com.lp.leetcodeLp.dp;

public class NumTrees3 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        NumTrees3 numTrees = new NumTrees3();
        System.out.println(numTrees.numTrees(4));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
