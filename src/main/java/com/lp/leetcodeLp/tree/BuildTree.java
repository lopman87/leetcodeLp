package com.lp.leetcodeLp.tree;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||inorder==null)return null;
        if (preorder.length!=inorder.length)return null;
        
        return null;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        BuildTree numTrees = new BuildTree();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(numTrees.buildTree(preorder,inorder));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
