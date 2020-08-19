package com.lp.leetcodeLp.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }


        Integer path = 0;
        List<Integer> allPath = new ArrayList<>();
        printTree(root, path , allPath);
        for (Integer aa: allPath ) {
            if (aa == sum)return true;
        }
        return false;
    }


    private void printTree(TreeNode root , Integer path, List<Integer> allPath){
        if (root == null ){
            return;
        }
        path = path + root.val;

        if (root.left == null && root.right == null){
            allPath.add(path);
            return;
        }

        if (root.left != null){
            printTree(root.left, path, allPath);
        }
        if (root.right != null){
            printTree(root.right, path, allPath);
        }
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        HasPathSum numTrees = new HasPathSum();

        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(5);
        root.right= new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);


        System.out.println(numTrees.hasPathSum(root,45));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
