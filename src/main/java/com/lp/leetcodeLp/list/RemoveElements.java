package com.lp.leetcodeLp.list;

import java.util.ArrayList;
import java.util.List;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)return head;
        if (head.next == null){
            if (head.val == val)return null;
            return head;
        }
        List<Integer> integerList = new ArrayList<>();
        ListNode tmpHead = new ListNode(Integer.MIN_VALUE);
        ListNode tmpFlag = tmpHead;
        tmpFlag.next = head;
        while (tmpFlag != null){
            if (tmpFlag.val != val){
                integerList.add(tmpFlag.val);
            }
            tmpFlag=tmpFlag.next;
        }
        ListNode hhh = new ListNode(Integer.MAX_VALUE);
        ListNode tmpFlag11 = hhh;
        while (!integerList.isEmpty()){
            int aa = integerList.remove(0);
            tmpFlag11.next = new ListNode(aa);
            tmpFlag11 = tmpFlag11.next;
        }
        return hhh.next.next;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        RemoveElements numTrees = new RemoveElements();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        ListNode lll = numTrees.removeElements(head,1);
        while (lll!=null){
            System.out.println(lll.val);
            lll = lll.next;
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start));
    }
}
