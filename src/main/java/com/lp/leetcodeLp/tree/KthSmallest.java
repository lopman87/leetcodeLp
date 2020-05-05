package com.lp.leetcodeLp.tree;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {

        return 0;
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
