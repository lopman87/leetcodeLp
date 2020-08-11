package com.lp.leetcodeLp.list;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
