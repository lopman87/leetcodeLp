package com.lp.leetcodeLp.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {

    static Map<Integer ,Integer> tmp= new HashMap<>();

    public static int numTrees(int n) {
        if (n <= 1){
            return n;
        }
        if (tmp.containsKey(n)){
            return tmp.get(n);
        }
        int res = doNumTrees(n);
        tmp.put(n,res);
        return res;
    }

    private static int doNumTrees(int n){
        for (int i = 1; i < n+1; i++) {
            //选中根节点
        }
        return 0;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(numTrees(8));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
