package com.lp.leetcodeLp.list;

import java.util.Stack;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)return head;
        Stack<Integer> listNodeStack = new Stack<>();
        ListNode tmpHead = head;
        while (tmpHead != null){
            listNodeStack.push(tmpHead.val);
            tmpHead = tmpHead.next;
        }
        ListNode newList = new ListNode(Integer.MIN_VALUE);
        ListNode newHead = newList;
        while (!listNodeStack.isEmpty()){
            ListNode top = new ListNode(listNodeStack.pop());
            newHead.next = top;
            newHead = newHead.next;
        }
        return  newList.next;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        ReverseList numTrees = new ReverseList();

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head.next.next.next.next.next = new ListNode(6);

        System.out.println(numTrees.reverseList(head).next.val);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
