package com.lp.leetcodeLp.tree;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsCousins {



    public boolean isCousins(TreeNode root, int x, int y) {



        return false;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IsCousins numTrees = new IsCousins();

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.right=new TreeNode(21);
        root.right= new TreeNode(3);


        TreeNode root1 = new TreeNode(2);
        System.out.println(numTrees.isCousins(root ,5, 4));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
