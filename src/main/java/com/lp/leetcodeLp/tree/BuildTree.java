package com.lp.leetcodeLp.tree;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [12,9,2,8,20,15,7]
 * 中序遍历 inorder = [2,9,8,12,15,20,7]
 * 返回如下的二叉树：
 *
 *      12
 *    /   \
 *   9    20
 *  / \  /  \
 * 2  8 15   7
 *  
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {

    private int findIndex(int[] inorder, int rootVal){
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal){
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||inorder==null)return null;
        if (preorder.length!=inorder.length)return null;
        int rootVal = preorder[0];

        TreeNode root = new TreeNode(rootVal);
        if (preorder.length == 1){
            return root;
        }


        int rootIndex = findIndex(inorder,rootVal);

        int leftWidth = rootIndex-0;

        int[] tempLeftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);

        int[] tempRightInorder = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);

        int[] tempLeftPreorder = Arrays.copyOfRange(preorder, 1, leftWidth+1);

        int[] tempRightPreorder = Arrays.copyOfRange(preorder, leftWidth+1, inorder.length);


        root.left = buildTree(tempLeftPreorder,tempLeftInorder);

        root.right = buildTree(tempRightPreorder,tempRightInorder);

        return root;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        BuildTree numTrees = new BuildTree();
        int[] preorder = {12,9,2,8,20,7};
        int[] inorder = {2,9,8,12,20,7};
        TreeNode root = numTrees.buildTree(preorder,inorder);
        numTrees.visitTree(root);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }

    private void visitTree(TreeNode root){
        if (root == null)return;
        System.out.println(root.val);
        visitTree(root.left);
        visitTree(root.right);
    }
}
