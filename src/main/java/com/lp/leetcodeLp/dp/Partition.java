package com.lp.leetcodeLp.dp;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty() || "".equals(s))return result;
        char[] tmpArray = s.toCharArray();
        boolean[][] dp = new boolean[tmpArray.length][tmpArray.length];
        dp[0][0]=true;
        for (int i = 1; i < tmpArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i==j)dp[i][j]=true;
                boolean flag = (tmpArray[i] == tmpArray[j]);
                dp[i-1][j+1] = flag && dp[i][j];
            }
        }
        return result;
    }


    public static void main(String[] args){

        Partition cache = new Partition();
        List<List<String>> lists = cache.partition("aab");
        for (List<String> asa: lists ) {
            System.out.println(Arrays.toString(asa.toArray()));
        }
    }
}
