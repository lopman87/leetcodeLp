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
        if (head == null){
            return head;
        }
        if (!hasDup(head)){
            return head;
        }
        ListNode tmpHead = head;
        while (tmpHead!= null){
            ListNode tmp = null;
            if (tmpHead.next!=null && tmpHead.val == tmpHead.next.val){
                tmp = tmpHead.next;
                tmpHead.next = tmp.next;
            }
            tmpHead = tmpHead.next;
        }
        return deleteDuplicates(head);
    }
    private boolean hasDup(ListNode head){
        ListNode tmpHead = head;
        while (tmpHead!= null){
            if (tmpHead.next!=null && tmpHead.val == tmpHead.next.val){
                return true;
            }
            tmpHead = tmpHead.next;
        }
        return false;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        DeleteDuplicatesV2 numTrees = new DeleteDuplicatesV2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(3);
        ListNode ggg = numTrees.deleteDuplicates(head);
        System.out.println(ggg);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
