package com.lp.leetcodeLp.list;

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {

        return null;
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
