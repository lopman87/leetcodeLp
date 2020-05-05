package com.lp.leetcodeLp.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        visitTree(root,result);
        return result.get(k-1);
    }

    private void visitTree(TreeNode root , List<Integer> result){
        if (root==null)return;
        visitTree(root.left,result);
        result.add(root.val);
        visitTree(root.right,result);
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        KthSmallest numTrees = new KthSmallest();

        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(5);
        root.right= new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);


        System.out.println(numTrees.kthSmallest(root , 2));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
