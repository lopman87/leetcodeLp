package com.lp.leetcodeLp.tree;

import java.util.Comparator;
import java.util.TreeSet;

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)return 0;
        TreeSet<String> treeSet = new TreeSet<>(Comparator.comparingInt(String::length).reversed());
        visit(root , treeSet , "");
        String path1 = treeSet.pollFirst();
        String path2 = treeSet.pollFirst();
        path1 = path1.replace("-","");
        path2 = path2.replace("-","");
        return path1.length()+path2.length()-2;
    }

    private void visit(TreeNode root , TreeSet<String> treeSet , String path){
        if (root==null)return;
        path += root.val;
        if (root.left==null&&root.right==null){
            treeSet.add(path);
        }else {
            visit(root.left , treeSet , path+"-");
            visit(root.right , treeSet , path+"-");
        }
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        DiameterOfBinaryTree numTrees = new DiameterOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right= new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.right = new TreeNode(6);

        System.out.println(numTrees.diameterOfBinaryTree(root));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
