package com.lp.leetcodeLp.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)return head;
        ListNode tmpHead = head;
        Stack<Integer> integers = new Stack<>();
        int MM = 1;
        while (tmpHead!=null){
            if (MM >= m && MM <= n){
                integers.add(tmpHead.val);
            }
            tmpHead = tmpHead.next;
            MM = MM+1;
        }
        ListNode tmpHead1 = head;
        int NN = 1;
        while (tmpHead1!=null){
            if (NN >= m && NN <= n){
                tmpHead1.val = integers.pop();
            }
            tmpHead1 = tmpHead1.next;
            NN = NN+1;
        }
        return head;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        ReverseBetween numTrees = new ReverseBetween();

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head.next.next.next.next.next = new ListNode(6);
        ListNode mmm = numTrees.reverseBetween(head,1,6);
        System.out.println(mmm.val);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
