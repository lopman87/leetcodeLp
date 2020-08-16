package com.lp.leetcodeLp.tree;

import com.lp.leetcodeLp.list.ListNode;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {

        return 0;
    }

    public static void main(String[] args){
        SumNumbers cache = new SumNumbers();

        TreeNode root = new TreeNode(3);
        root.right= new TreeNode(20);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);


        System.out.println(cache.sumNumbers(root));
    }
}
