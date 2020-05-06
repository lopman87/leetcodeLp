package com.lp.leetcodeLp.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> stringList = new ArrayList<>();
        if(root==null){
            return stringList;
        }
        printPathsRecur(root, stringList, "");
        return stringList;
    }


    void printPathsRecur(TreeNode node, List<String> stringList, String pathLen)
    {
        if (node == null)
            return;
        pathLen += node.val;
        if (node.left == null && node.right == null)
            stringList.add(pathLen);
        else
        {
            printPathsRecur(node.left, stringList, pathLen+ "->");
            printPathsRecur(node.right, stringList, pathLen+ "->");
        }
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        BinaryTreePaths numTrees = new BinaryTreePaths();

        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(5);
        root.right= new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        numTrees.binaryTreePaths(root);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
