package com.lp.leetcodeLp.tree;


public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        java.util.LinkedList<TreeNode> nodeLinkedHashSet = new java.util.LinkedList<>();
        visitTree(root,nodeLinkedHashSet);
        for (int i = 0; i < nodeLinkedHashSet.size()-1; i++) {
            if (nodeLinkedHashSet.get(i) == p){
                return nodeLinkedHashSet.get(i+1);
            }
        }
        return null;
    }

    private void visitTree(TreeNode root,java.util.LinkedList<TreeNode> nodeLinkedHashSet){
        if (root==null)return;
        visitTree(root.left,nodeLinkedHashSet);
        nodeLinkedHashSet.add(root);
        visitTree(root.right,nodeLinkedHashSet);
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        InorderSuccessor numTrees = new InorderSuccessor();

        TreeNode root = new TreeNode(2);
        root.left=new TreeNode(1);
        root.right= new TreeNode(3);


        TreeNode result = numTrees.inorderSuccessor(root,root.right);
        System.out.println(result == null ? "null" :result.val);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
