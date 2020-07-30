package com.lp.leetcodeLp.array;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();

        int[] lll = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            lll[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            char end = chars[i];
            for (int j = 0; j < i; j++) {
                if (chars[j] != end){
                    lll[i] = Math.max( lll[i] , (lll[j] +1) );
                    max = Math.max( max ,  lll[i] );
                }else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(lll));
        return max;
    }


    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        Map<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!windows.containsKey(chars[i])){
                windows.put(chars[i], i);
                max = Math.max(max , windows.size());
            }else{
                Integer index = windows.get(chars[i]);
                Iterator<Character> iterator = windows.keySet().iterator();
                while (iterator.hasNext()){
                    Character characterIntegerEntry = iterator.next();
                    Integer aa = windows.get(characterIntegerEntry);
                    if (aa < index){
                        iterator.remove();
                        max = Math.max(max , windows.size());
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] a){
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("aab"));
    }
}
