package com.lp.leetcodeLp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     10
 *    / \
 *   5   15
 *      / \
 *     6   20
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        List<Integer> result = new ArrayList<>();
        visitTree(root,result);
        for (int i = 0; i < result.size()-1; i++) {
            if (result.get(i) >= result.get(i+1)){
                return false;
            }
        }
        return true;
    }

    private void visitTree(TreeNode root , List<Integer> result){
        if (root==null)return;
        visitTree(root.left,result);
        result.add(root.val);
        visitTree(root.right,result);
    }



    public static void main(String args[]){
        long start = System.currentTimeMillis();
        IsValidBST numTrees = new IsValidBST();

        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(5);
        root.right= new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);


        System.out.println(numTrees.isValidBST(root));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
