package com.lp.leetcodeLp.dp;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(10));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }

    public int numTrees(int n) {
        if (n <= 2){
            return n;
        }
        return doNumTrees(n);
    }

    private int doNumTrees(int n){
        List<List<Integer>> lists = permute(n);
        Set<String> tmpSet = new HashSet<>();
        for (List<Integer> tmpList:lists) {
            Node root = buildTree(tmpList);
            StringBuilder stringBuilder = new StringBuilder();
            visitNode(root,stringBuilder);
            tmpSet.add(stringBuilder.toString());
        }
        return tmpSet.size();
    }
    private Node buildTree(List<Integer> tmpList){
        Node root = new Node(tmpList.get(0));
        for (int i = 1; i < tmpList.size(); i++) {
            doBuildTree(root, tmpList.get(i));
        }
        return root;
    }


    private void doBuildTree(Node root, int newVal){
        if (root.getCurrentVal() == newVal){
            return;
        }
        if (root.getCurrentVal() > newVal){
            if (root.getLeftNode() == null){
                Node tmp = new Node(newVal);
                root.setLeftNode(tmp);
            }else{
                doBuildTree(root.getLeftNode() , newVal);
            }
        }else{
            if (root.getRightNode() == null){
                Node tmp = new Node(newVal);
                root.setRightNode(tmp);
            }else{
                doBuildTree(root.getRightNode() , newVal);
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





    public List<List<Integer>> permute(int n) {
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = i+1;
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(0, tmp, result);
        return result;
    }

    private void helper(int start, int[] nums, List<List<Integer>> result){
        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
