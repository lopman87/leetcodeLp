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

    static Map<Integer ,Integer> tmp= new HashMap<>();

    public static int numTrees(int n) {
        if (n <= 1){
            return n;
        }
        if (tmp.containsKey(n)){
            return tmp.get(n);
        }
        int res = doNumTrees(n);
        tmp.put(n,res);
        return res;
    }

    private static int doNumTrees(int n){


        return 0;
    }

    private void buildTree(Node root, int newVal){
        if (root.getCurrentVal() == newVal){
            return;
        }


        if (root.getCurrentVal() > newVal){
            buildTree(root.getLeftNode() , newVal);
        }else{
            buildTree(root.getRightNode() , newVal);
        }
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
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(numTrees(8));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
