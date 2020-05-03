package com.lp.leetcodeLp.list;

import java.util.List;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode tmpHead = head;
        while (tmpHead!=null && tmpHead.next != null){

            if (tmpHead.next != null){
                ListNode currentNext = tmpHead.next;
                int currentVal = tmpHead.val;
                tmpHead.val = currentNext.val;
                currentNext.val = currentVal;
            }

            tmpHead = tmpHead.next.next;
        }
        return head;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        SwapPairs numTrees = new SwapPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode lll = numTrees.swapPairs(head);
        while (lll!=null){
            System.out.println(lll.val);
            lll = lll.next;
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start));
    }
}
