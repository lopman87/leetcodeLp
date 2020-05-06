package com.lp.leetcodeLp.tree;

public class IsBalanced {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        try {
            int leftDeep = visitTree(root,0);
        }catch (Exception e){

        }
        return flag ;
    }
    private int visitTree(TreeNode root , int deep){
        if (root == null){
            return deep;
        }
        int leftDeep = deep;
        if (root.left!=null){
            leftDeep = visitTree(root.left , ++leftDeep);
        }
        int rightDeep = deep;
        if (root.right!=null){
            rightDeep = visitTree(root.right , ++rightDeep);
        }
        int diff = Math.abs(leftDeep-rightDeep);
        flag = diff <= 1 ;
        if (!flag){
            throw new RuntimeException();
        }
        return Math.max(leftDeep,rightDeep);
    }



    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IsBalanced numTrees = new IsBalanced();

        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.left.left= new TreeNode(3);
        root.left.left.left= new TreeNode(4);


        root.right= new TreeNode(2);
        root.right.right= new TreeNode(3);
        root.right.right.right= new TreeNode(4);
//
//
//        root.right.left= new TreeNode(15);
//        root.right.right= new TreeNode(7);
        System.out.println(numTrees.isBalanced(root));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
