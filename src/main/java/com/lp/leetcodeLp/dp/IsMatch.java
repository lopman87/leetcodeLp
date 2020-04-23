package com.lp.leetcodeLp.dp;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        System.out.println("---->"+isMatch(s,0,p,0));
        return s.matches(p);
    }

    public boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (sIndex >= s.length() || pIndex >= p.length()){
            if (pIndex >= p.length() && sIndex < s.length()){
                return false;
            }else if (sIndex >= s.length() && pIndex < p.length()){
                return false;
            }else {
                return true;
            }
        }
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        if (pChar == '*'){
            char perP = p.charAt(pIndex-1);
            int ss = 0;
            if (perP== '.'){
                ss = findIndex(s,sIndex,sChar);
            }else{
                ss = findIndex(s,sIndex,perP);
            }
            return isMatch(s , ss , p , pIndex+1);
        }else if (pChar == '.' || pChar == sChar){
            return isMatch(s , sIndex+1 , p , pIndex+1);
        }else{
            return isMatch(s , sIndex , p , pIndex+1);
        }

    }
    private int findIndex(String s, int sIndex,char perP){
        while ( sIndex < s.length() && s.charAt(sIndex) == perP){
            sIndex++;
        }
        return sIndex;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IsMatch numTrees = new IsMatch();
        String s = "aaa";
        String p = "a*a";
        System.out.println(numTrees.isMatch(s,p));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
