package com.lp.leetcodeLp.tree;


import java.util.Stack;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {

        return 0;
    }


    public void depthFirstSearch(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);

        while(!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            System.out.print(node.val + " ");

            if(node.right != null) {
                nodeStack.push(node.right);
            }
            if(node.left != null) {
                nodeStack.push(node.left);
            }
        }
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
