package com.lp.leetcodeLp.list;

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

        return head;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        RemoveNthFromEnd numTrees = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode lll = numTrees.removeNthFromEnd(head,6);
        while (lll!=null){
            System.out.println(lll.val);
            lll = lll.next;
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start));
    }
}
