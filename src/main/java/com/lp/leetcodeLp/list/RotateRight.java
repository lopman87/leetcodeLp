package com.lp.leetcodeLp.list;

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null){
            return head;
        }
        int length = 0;
        ListNode tmpHead = new ListNode(Integer.MAX_VALUE);
        tmpHead = head;
        while (tmpHead != null){
            length ++;
            tmpHead = tmpHead.next;
        }
        if (length == 0){
            return head;
        }
        int realK = k % length;
        if (realK == 0){
            return head;
        }
        tmpHead = head;
        int index = realK;
        while (index > 0){
            tmpHead = rotateRight(tmpHead);
            index--;
        }
        return tmpHead;
    }


    private ListNode rotateRight(ListNode head) {
        ListNode tmpHeadResult = new ListNode(Integer.MAX_VALUE);
        ListNode tmpHead = new ListNode(Integer.MAX_VALUE);
        tmpHead.next = head;
        tmpHeadResult.next = head;
        while (tmpHead.next != null){
            if (tmpHead.next.next == null){
                tmpHeadResult.val = tmpHead.next.val;
                tmpHead.next = null;
                break;
            }else{
                tmpHead = tmpHead.next;
            }
        }
        return tmpHeadResult;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        RotateRight numTrees = new RotateRight();

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        //head.next.next.next.next.next = new ListNode(6);


        ListNode result = numTrees.rotateRight(head ,2);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
