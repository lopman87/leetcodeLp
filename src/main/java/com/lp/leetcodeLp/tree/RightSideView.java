package com.lp.leetcodeLp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();

        return integerList;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        RightSideView numTrees = new RightSideView();

        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(5);
        root.right= new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        numTrees.rightSideView(root);
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
