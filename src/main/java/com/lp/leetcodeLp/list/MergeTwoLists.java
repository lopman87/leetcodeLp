package com.lp.leetcodeLp.list;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)return l2;
        if (l2 == null)return l1;
        ListNode resultHeadres = new ListNode(Integer.MIN_VALUE);
        ListNode resultHead = resultHeadres;
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        while (l1Head != null && l2Head !=null){
            ListNode tmp = null;
            if (l1Head.val < l2Head.val){
                tmp = new ListNode(l1Head.val);
                l1Head = l1Head.next;
            }else{
                tmp = new ListNode(l2Head.val);
                l2Head = l2Head.next;
            }
            resultHead.next = tmp;
            resultHead = resultHead.next;
        }
        while (l1Head != null){
            ListNode tmp = new ListNode(l1Head.val);
            resultHead.next = tmp;
            resultHead = resultHead.next;
            l1Head = l1Head.next;
        }
        while (l2Head != null){
            ListNode tmp = new ListNode(l2Head.val);
            resultHead.next = tmp;
            resultHead = resultHead.next;
            l2Head = l2Head.next;
        }
        return resultHeadres.next;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        MergeTwoLists numTrees = new MergeTwoLists();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(9);



        ListNode startHead = new ListNode(4);
        startHead.next = new ListNode(5);
        startHead.next.next = new ListNode(6);

        startHead.next.next.next = new ListNode(16);

        ListNode result = numTrees.mergeTwoLists(head , null);
        System.out.println(result.val);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
