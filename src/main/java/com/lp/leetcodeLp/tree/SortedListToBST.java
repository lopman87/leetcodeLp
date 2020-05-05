package com.lp.leetcodeLp.tree;

import com.lp.leetcodeLp.list.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null )return null;
        if (head.next == null)return new TreeNode(head.val);
        if (head.next.next == null){
            TreeNode root = new TreeNode(head.val);
            root.right =  new TreeNode(head.next.val);
            return root;
        }
        List<Integer> integerList = new LinkedList<>();
        ListNode tmpHead = head;
        while (tmpHead!=null){
            integerList.add(tmpHead.val);
            tmpHead = tmpHead.next;
        }
        Integer[] strings = integerList.stream().toArray(Integer[]::new);
        TreeNode root = buildTree(strings ,0 , strings.length-1);
        return root;
    }

    private TreeNode buildTree(Integer[] nums, int leftIndex , int rightIndex){

        int flag = (leftIndex+rightIndex)/2;

        TreeNode root = new TreeNode(nums[flag]);
        if (leftIndex == rightIndex){
            return root;
        }
        if (rightIndex-leftIndex <=1){
            root.right = new TreeNode(nums[flag+1]);
            return root;
        }
        root.left = buildTree(nums,leftIndex,flag-1);
        root.right = buildTree(nums,flag+1,rightIndex);
        return root;
    }

    public static void main(String[] args){
        SortedListToBST cache = new SortedListToBST();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(cache.sortedListToBST(head));
    }
}
