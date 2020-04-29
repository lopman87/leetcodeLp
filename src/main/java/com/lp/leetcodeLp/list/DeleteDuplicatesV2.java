package com.lp.leetcodeLp.list;

/**
 *
 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

 示例 1:

 输入: 1->2->3->3->4->4->5
 输出: 1->2->5
 示例 2:

 输入: 1->1->1->2->3
 输出: 2->3
 */
public class DeleteDuplicatesV2 {

    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    public static class ListNode {
        int val;
        DeleteDuplicates.ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        DeleteDuplicatesV2 numTrees = new DeleteDuplicatesV2();
        DeleteDuplicatesV2.ListNode head = new DeleteDuplicatesV2.ListNode(1);
        head.next = new DeleteDuplicates.ListNode(1);
        head.next.next = new DeleteDuplicates.ListNode(1);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(3);
        DeleteDuplicatesV2.ListNode ggg = numTrees.deleteDuplicates(head);
        System.out.println(ggg);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
