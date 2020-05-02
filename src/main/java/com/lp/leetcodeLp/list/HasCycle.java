package com.lp.leetcodeLp.list;

import java.util.concurrent.TimeUnit;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        if (head.next == head){
            return true;
        }
        ListNode slowPoint = head;
        ListNode fastPoint = head;
        while (slowPoint.next != null){
            if (fastPoint ==null || fastPoint.next == null){
                return false;
            }
            fastPoint = fastPoint.next.next;
            if (slowPoint != null && fastPoint != null && fastPoint == slowPoint){
                return true;
            }
            slowPoint = slowPoint.next;
        }
        return false;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        HasCycle numTrees = new HasCycle();


        ListNode startNode = new ListNode(0);

        ListNode head = new ListNode(1);
        startNode.next = head;


        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head.next.next.next.next.next = new ListNode(6);

        System.out.println(numTrees.hasCycle(startNode));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
