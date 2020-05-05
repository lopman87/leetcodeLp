package com.lp.leetcodeLp.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> treeNodeList = visitTree(root);
        for (int i = treeNodeList.size()-1; i >= 0 ; i--) {
            TreeNode nodeI = treeNodeList.get(i);
            boolean flag = find(nodeI , p,q);
            if (flag){
                return nodeI;
            }
        }
        return root;
    }

    private List<TreeNode> visitTree(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> treeNodeList = new ArrayDeque<>();
        treeNodeList.add(root);
        while (!treeNodeList.isEmpty()){
            TreeNode treeNode = treeNodeList.poll();
            result.add(treeNode);
            if (treeNode.left!=null){
                treeNodeList.add(treeNode.left);
            }
            if (treeNode.right!=null){
                treeNodeList.add(treeNode.right);
            }
        }
        return result;
    }

    private boolean find(TreeNode tmpRoot, TreeNode p, TreeNode q){
        return find(tmpRoot,p) && find(tmpRoot,q);
    }

    private boolean find(TreeNode tmpRoot, TreeNode p){
        if (tmpRoot == null){
            return false;
        }else{
            if (tmpRoot.val == p.val){
                return true;
            }else{
                return find(tmpRoot.left, p) || find(tmpRoot.right, p);
            }
        }
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LowestCommonAncestor numTrees = new LowestCommonAncestor();

        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(5);
        root.right= new TreeNode(1);

        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);

        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left.right.left;
        TreeNode q = root.left;

        TreeNode lowest = numTrees.lowestCommonAncestor(root,p,q);

        System.out.println(lowest.val);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
