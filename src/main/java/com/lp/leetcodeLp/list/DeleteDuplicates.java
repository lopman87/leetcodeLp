package com.lp.leetcodeLp.list;

import com.lp.leetcodeLp.dp.Rob;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {

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
        DeleteDuplicates numTrees = new DeleteDuplicates();
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
