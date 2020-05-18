package com.lp.leetcodeLp.dp;

import com.lp.leetcodeLp.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0)return false;
        if (x < 10)return true;
        String tmpStr = x+"";
        return isPalindrome(tmpStr ,0, tmpStr.length()-1 , tmpStr.length() % 2 == 0);
    }


    private boolean isPalindrome(String x , int leftIndex , int rightIndex , boolean even) {
        if (even){
            if (rightIndex - leftIndex == -1){
                return true;
            }
        }else{
            if (rightIndex - leftIndex == 0){
                return true;
            }
        }
        if (x.charAt(leftIndex) == x.charAt(rightIndex)){
            return isPalindrome(x, ++leftIndex, --rightIndex,even);
        }else{
            return false;
        }
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null)return true;
        if (head.next == null)return true;
        List<Integer> stringBuilder = new ArrayList<>();
        ListNode tmpHead = head;
        while (tmpHead!=null){
            stringBuilder.add(tmpHead.val);
            tmpHead = tmpHead.next;
        }
        return isPalindrome(stringBuilder ,0, stringBuilder.size()-1 , stringBuilder.size() % 2 == 0);
    }

    private boolean isPalindrome(List<Integer> x , int leftIndex , int rightIndex , boolean even) {
        if (even){
            if (rightIndex - leftIndex == -1){
                return true;
            }
        }else{
            if (rightIndex - leftIndex == 0){
                return true;
            }
        }
        if (x.get(leftIndex).intValue() == x.get(rightIndex).intValue()){
            return isPalindrome(x, ++leftIndex, --rightIndex,even);
        }else{
            return false;
        }
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IsPalindrome numTrees = new IsPalindrome();
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        System.out.println(numTrees.isPalindrome(head));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
