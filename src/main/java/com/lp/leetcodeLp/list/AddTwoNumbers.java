package com.lp.leetcodeLp.list;


/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null  && l2 == null)return null;
        StringBuilder stringBuilderL1 = new StringBuilder();
        StringBuilder stringBuilderL2 = new StringBuilder();
        ListNode tmpL1 = l1;
        ListNode tmpL2 = l2;
        while (tmpL1!=null){
            stringBuilderL1.append(tmpL1.val);
            tmpL1 = tmpL1.next;
        }
        while (tmpL2!=null){
            stringBuilderL2.append(tmpL2.val);
            tmpL2 = tmpL2.next;
        }
        java.math.BigDecimal l11 = new java.math.BigDecimal(stringBuilderL1.length() ==0 ? "0":stringBuilderL1.reverse().toString());
        java.math.BigDecimal l22 = new java.math.BigDecimal(stringBuilderL2.length() ==0 ? "0":stringBuilderL2.reverse().toString());
        java.math.BigDecimal l33 = l22.add(l11);
        StringBuilder stringBuilderL3 = new StringBuilder();
        stringBuilderL3.append(l33);
        StringBuilder l4 = stringBuilderL3.reverse();
        ListNode result = new ListNode(0);
        ListNode flag = result;
        for (int i = 0; i < l4.length(); i++) {
            char ch = l4.charAt(i);
            ListNode tmp = new ListNode(Integer.parseInt(String.valueOf(ch)));
            flag.next = tmp;
            flag = tmp;
        }

        return result.next;
    }

    public static void main(String args[]){

        String dd ="1000000000000000000000000000001";
        System.out.println(new java.math.BigDecimal(dd));;

        long start = System.currentTimeMillis();
        AddTwoNumbers numTrees = new AddTwoNumbers();
        ListNode head = new ListNode(7);
        head.next = new ListNode(1);
        head.next.next = new ListNode(6);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(2);


        ListNode ggg = numTrees.addTwoNumbers(head ,null);
        System.out.println(ggg);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
