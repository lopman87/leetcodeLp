package com.lp.leetcodeLp.list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }
        ListNode tmpHead_0 = head;
        ListNode tmpHead_1 = head;
        int start_0 = 0;
        while (tmpHead_0 != null){
            start_0++;
            tmpHead_0 = tmpHead_0.next;
        }
        int start_1 = start_0 - n;
        if (start_1 == 0){
            return head.next;
        }
        int flag = 0;
        while (tmpHead_1 != null){
            ListNode tmp = null;
            if (flag+1 == start_1){
                tmp = tmpHead_1.next;
                tmpHead_1.next = tmp.next;
                tmp.next = null;
                break;
            }
            flag++;
            tmpHead_1 = tmpHead_1.next;
        }
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
