package com.lp.leetcodeLp.list;

import java.util.*;

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

    static Map<Integer,Integer> integerSet = new HashMap<>();
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        hasDup(head);
        ListNode tmpHead = head;
        while (tmpHead!= null){
            ListNode tmp = null;
            if (tmpHead.next!=null && integerSet.containsKey(tmpHead.next.val) && integerSet.get(tmpHead.next.val) != 0){
                int old = integerSet.get(tmpHead.next.val);
                integerSet.put(tmpHead.next.val, --old);
                tmp = tmpHead.next;
                tmpHead.next = tmp.next;
                tmp.next = null;
            }
            tmpHead = tmpHead.next;
        }
        if (stop()){
            return head;
        }
        return deleteDuplicates(head);
    }

    private boolean stop(){
        boolean flag = true;
        Iterator<Integer> iterator = integerSet.values().iterator();
        while (iterator.hasNext()){
           if (iterator.next() > 0) {
               flag = false;
               break;
           }
        }
        return flag;
    }
    private void hasDup(ListNode head){
        ListNode tmpHead = head;
        while (tmpHead!= null){
            if (tmpHead.next!=null && (tmpHead.val == tmpHead.next.val)){
                if (integerSet.containsKey(tmpHead.val)){
                    int old =  integerSet.get(tmpHead.val);
                    integerSet.put(tmpHead.val, ++old);
                }else {
                    integerSet.put(tmpHead.val , 2);
                }
            }
            tmpHead = tmpHead.next;
        }
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        DeleteDuplicatesV2 numTrees = new DeleteDuplicatesV2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);
        ListNode ggg = numTrees.deleteDuplicates(head);
        System.out.println(ggg);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
