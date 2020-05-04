package com.lp.leetcodeLp.list;


/**
 *
 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

 示例 1:

 输入: 4->2->1->3
 输出: 1->2->3->4
 示例 2:

 输入: -1->5->3->4->0
 输出: -1->0->3->4->5

 https://leetcode-cn.com/problems/sort-list/

 */
public class SortList {


    public ListNode sortList(ListNode head) {
        if (head==null || head.next == null)return head;
        ListNode tmpHead = head;

        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode flag = result;
        StringBuilder stringBuilder = new StringBuilder();
        while (tmpHead!=null){
            stringBuilder.append(tmpHead.val).append(",");
            tmpHead = tmpHead.next;
        }
        String[] strings = stringBuilder.toString().split(",");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            int d = Integer.parseInt(strings[i]);
            arr[i] = d;
        }
        java.util.Arrays.sort(arr);
        for (int zz:arr) {
            ListNode ss = new ListNode(zz);
            flag.next = ss;
            flag = flag.next;
        }
        return result.next;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        SortList numTrees = new SortList();
        ListNode head = new ListNode(122);
        head.next = new ListNode(2);
        head.next.next = new ListNode(33);
        head.next.next.next = new ListNode(24);
        head.next.next.next.next = new ListNode(-15);

        head.next.next.next.next.next = new ListNode(6);

        System.out.println(numTrees.sortList(head));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
