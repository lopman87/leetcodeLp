package com.lp.leetcodeLp.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();

        printByLevel(root);


        return arr;
    }

    private void printByLevel(TreeNode root){

        List<TreeNode> visitList = new ArrayList<>();

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()){
            TreeNode treeNode = treeNodeQueue.poll();

            visitList.add(treeNode);

            if (treeNode.left != null){
                treeNodeQueue.add(treeNode.left);
            }
            if (treeNode.right != null){
                treeNodeQueue.add(treeNode.right);
            }
            System.out.println(visitList.size());
            System.out.println("-----------------------------");
        }

        for (TreeNode tree:visitList) {
            System.out.println(tree.val);
        }
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LevelOrderBottom numTrees = new LevelOrderBottom();

        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(5);
        root.right= new TreeNode(1);

        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);

        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);


        List<List<Integer>> lowest = numTrees.levelOrderBottom(root);

        System.out.println(Arrays.toString(lowest.toArray()));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
