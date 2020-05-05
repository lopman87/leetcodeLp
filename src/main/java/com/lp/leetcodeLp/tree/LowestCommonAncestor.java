package com.lp.leetcodeLp.tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LowestCommonAncestor numTrees = new LowestCommonAncestor();
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        TreeNode root = new TreeNode(1);


        System.out.println(numTrees.lowestCommonAncestor(root,p,q));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
