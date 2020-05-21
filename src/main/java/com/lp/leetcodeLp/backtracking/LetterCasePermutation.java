package com.lp.leetcodeLp.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> aa = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        buildStr(S,stringBuilder,aa,0,S.length());
        return aa;
    }
    private void buildStr(String S,StringBuilder stringBuilder , List<String> aa  , int times, int end){
        if (times == end){
            aa.add(stringBuilder.toString());
            return;
        }
        for (int i = times; i < S.length(); i++) {
            char ii = S.charAt(i);
            stringBuilder.append(S.replace(S.charAt(i) , ii));
            char upperII = Character.toUpperCase(ii);
            stringBuilder.append(S.replace(S.charAt(i) , upperII));
        }
    }

    public static void main(String[] args){
        LetterCasePermutation cache = new LetterCasePermutation();
        System.out.println(Arrays.toString(cache.letterCasePermutation("ab").toArray()));
    }
}
