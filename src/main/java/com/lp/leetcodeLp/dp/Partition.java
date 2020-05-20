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
    public static ArrayList<String> list = new ArrayList<String>();



    public List<List<String>> partition(String string) {
        List<List<String>> result = new ArrayList<>();
        int step = string.length();
        while (step > 0){

        }
        return result;
    }

    private List<String> buildSubString(String string , int step){
        List<String> aaa = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            aaa.add(string.substring(i,step)) ;
        }
        return aaa;
    }


    public static void main(String[] args){

        Partition cache = new Partition();

        System.out.println(cache.partition("aab"));

    }
}
