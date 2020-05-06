package com.lp.leetcodeLp.tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||inorder==null)return null;
        if (preorder.length!=inorder.length)return null;
        for (int i = 0; i < preorder.length; i++) {
            int rootVal = preorder[i];
            
        }
        return null;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        BuildTree numTrees = new BuildTree();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(numTrees.buildTree(preorder,inorder));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
