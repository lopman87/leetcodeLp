package com.lp.leetcodeLp.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiameterOfBinaryTree {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDep(root);
        return max;
    }

    private int getDep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDep = getDep(root.left);
        int rightDep = getDep(root.right);
        max = Math.max(leftDep + rightDep, max);
        return Math.max(leftDep, rightDep) + 1;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        DiameterOfBinaryTree numTrees = new DiameterOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right= new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(numTrees.diameterOfBinaryTree(root));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
