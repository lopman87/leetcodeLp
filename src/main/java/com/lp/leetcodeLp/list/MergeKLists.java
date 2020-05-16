package com.lp.leetcodeLp.list;

import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length ==0)return null;
        if (lists.length == 1)return lists[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode tmpResult = result;
        for (int i = 0; i < lists.length; i++) {
            ListNode tmp = lists[i];
            ListNode tmpHead = tmp;
            while (tmpHead != null){
                priorityQueue.add(tmpHead.val);
                tmpHead = tmpHead.next;
            }
        }
        while (!priorityQueue.isEmpty()){
            tmpResult.next = new ListNode(priorityQueue.poll());
            tmpResult = tmpResult.next;
        }
        return result.next;
    }



    public static void main(String args[]){
        long start = System.currentTimeMillis();
        MergeKLists numTrees = new MergeKLists();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(9);



        ListNode startHead = new ListNode(4);
        startHead.next = new ListNode(5);
        startHead.next.next = new ListNode(6);

        startHead.next.next.next = new ListNode(16);


        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = head;
        listNodes[1] = startHead;

        ListNode result = numTrees.mergeKLists(listNodes);
        System.out.println(result.val);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
