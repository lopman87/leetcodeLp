package com.lp.leetcodeLp.dp;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsMatchWildcard {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)return false;
        return isMatch(s,0,p,0);
    }

    public boolean isMatch(String s, int sIndex, String p, int pIndex ) {
        if(pIndex>=p.length()) return sIndex==s.length();
        boolean f9 = false;
        if(  (sIndex < s.length()) && (p.charAt(pIndex) == '?'||p.charAt(pIndex) == s.charAt(sIndex))){
            f9 = true;
        }else if (p.charAt(pIndex) == '*'){
            //匹配空字符串
            boolean f0 = isMatch(s,sIndex, p,pIndex+1);
            //匹配任意的字符串
            boolean f1 = false;
            while (sIndex < s.length()){
                ++sIndex;
                f1 = isMatch(s,sIndex, p,pIndex+1);
                if (f1)break;
            }
            return f0 || f1;
        }
        return f9 && isMatch(s,sIndex+1, p,pIndex+1);
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IsMatchWildcard numTrees = new IsMatchWildcard();
        String s = "adceb";
        String p = "*a*b";
        System.out.println(numTrees.isMatch(s,p));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
