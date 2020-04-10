package com.lp.leetcodeLp.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {


    public static int numTrees(int n) {
        if (n <= 2){
            return n;
        }
        if (n == 3){
            return 5;
        }
        return doNumTrees(n);
    }

    private static int doNumTrees(int n){


        return 0;
    }

    private void buildTree(Node root, int newVal){
        if (root.getCurrentVal() == newVal){
            return;
        }
        if (root.getCurrentVal() > newVal){
            if (root.getLeftNode() == null){
                Node tmp = new Node(newVal);
                root.setLeftNode(tmp);
            }else{
                buildTree(root.getLeftNode() , newVal);
            }
        }else{
            if (root.getRightNode() == null){
                Node tmp = new Node(newVal);
                root.setRightNode(tmp);
            }else{
                buildTree(root.getRightNode() , newVal);
            }
        }
    }

    private void visitNode(Node root, StringBuilder sb){
        if (root == null){
        }
        if (root.getLeftNode() != null){
            visitNode(root.getLeftNode(),sb);
        }
        String current = root.getCurrentVal()+"";
        if (root.getRightNode() != null){
            visitNode(root.getRightNode(),sb);
        }
        sb.append(current);
    }


    private static class Node{
        int currentVal;
        Node leftNode;
        Node rightNode;

        public int getCurrentVal() {
            return currentVal;
        }

        public void setCurrentVal(int currentVal) {
            this.currentVal = currentVal;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
        public Node(int currentVal,Node leftNode,Node rightNode){
            this.setCurrentVal(currentVal);
            this.setLeftNode(leftNode);
            this.setRightNode(rightNode);
        }

        public Node(int currentVal){
            this.setCurrentVal(currentVal);
        }
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(numTrees(8));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
