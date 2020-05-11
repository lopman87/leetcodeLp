package com.lp.leetcodeLp.tree;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)return root;
        if (root.left !=null && root.right!=null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }else if (root.left !=null && root.right==null){
            root.right = root.left;
            root.left = null;
        }else if (root.left ==null && root.right!=null){
            root.left = root.right;
            root.right = null;
        }else if (root.left ==null && root.right==null){
            return root;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        InvertTree numTrees = new InvertTree();

        TreeNode root = new TreeNode(4);
        root.left= new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

//        root.right= new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);

        TreeNode fff =  numTrees.invertTree(root);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
