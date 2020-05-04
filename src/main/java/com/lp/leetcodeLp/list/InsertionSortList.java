package com.lp.leetcodeLp.list;

/**
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next == null)return head;
        ListNode tmpHead = head;
        return null;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        InsertionSortList numTrees = new InsertionSortList();
        ListNode head = new ListNode(122);
        head.next = new ListNode(2);
        head.next.next = new ListNode(33);
        head.next.next.next = new ListNode(24);
        head.next.next.next.next = new ListNode(-15);

        head.next.next.next.next.next = new ListNode(6);

        System.out.println(numTrees.insertionSortList(head));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
