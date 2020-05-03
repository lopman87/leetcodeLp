package com.lp.leetcodeLp.list;

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

        return head;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        RemoveNthFromEnd numTrees = new RemoveNthFromEnd();
        ListNode startNode = new ListNode(0);
        ListNode head = new ListNode(1);
        startNode.next = head;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(numTrees.removeNthFromEnd(startNode,2));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
