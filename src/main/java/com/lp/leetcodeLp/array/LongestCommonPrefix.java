package com.lp.leetcodeLp.array;


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 1)return "";
        java.util.Arrays.sort(strs, java.util.Comparator.comparingInt(String::length));
        String index0 = strs[0];
        int len = commonStr(index0, strs ,0);
        return index0.substring(0,len);
    }

    private int commonStr(String index0, String[] strs, int index){
        if (index == index0.length()){
            return index;
        }
        char flag = index0.charAt(index);
        for (int i = 1; i < strs.length; i++) {
            char tmpS = strs[i].charAt(index);
            if (flag != tmpS){
                return index;
            }
        }
        return commonStr(index0,strs , ++index);
    }


    public static void main(String[] args){

        LongestCommonPrefix cache = new LongestCommonPrefix();
        String[] nums = {"flower","flow","flo"};
        System.out.println(cache.longestCommonPrefix(nums));
    }
}
