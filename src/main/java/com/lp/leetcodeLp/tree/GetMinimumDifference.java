package com.lp.leetcodeLp.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetMinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        if (root ==null){
            return -1;
        }
        List<Integer> res = new ArrayList<>();
        visitTree(root,res);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size()-1; i++) {
            for (int j = i+1; j < res.size(); j++) {
                int resdd = Math.abs(res.get(i) - res.get(j));
                if (resdd < min){
                    min = resdd;
                }
            }
        }
        return min;
    }


    public int getMinimumDifference1(TreeNode root) {
        if (root ==null){
            return -1;
        }

        return -1;
    }

    private void visitTree(TreeNode root , List<Integer> res){
        if (root==null)return;
        visitTree(root.left,res);
        res.add(root.val);
        visitTree(root.right,res);
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        GetMinimumDifference numTrees = new GetMinimumDifference();

        TreeNode root = new TreeNode(543);
        root.left=new TreeNode(384);
        root.left.right=new TreeNode(445);

        root.right= new TreeNode(652);
        root.right.right = new TreeNode(699);

        System.out.println(numTrees.getMinimumDifference(root));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
