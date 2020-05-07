package com.lp.leetcodeLp.tree;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BSTIterator {

    private LinkedList<TreeNode> nodeLinkedHashSet = new LinkedList<>();

    private Iterator<TreeNode> iterator;

    public BSTIterator(TreeNode root) {
        visitInorder(root);
        if (!nodeLinkedHashSet.isEmpty()){
            this.iterator = nodeLinkedHashSet.iterator();
        }
    }

    private void visitInorder(TreeNode root){
        if (root==null)return;
        visitInorder(root.left);
        nodeLinkedHashSet.add(root);
        visitInorder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        if (iterator == null){
            return -1;
        }
        TreeNode treeNode = iterator.next();
        return treeNode==null?-1:treeNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (iterator == null){
            return false;
        }
        return iterator.hasNext();
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        TreeNode root = new TreeNode(7);
        root.left= new TreeNode(3);
        root.right= new TreeNode(15);
        root.right.left= new TreeNode(9);
        root.right.right= new TreeNode(20);
        BSTIterator numTrees = new BSTIterator(root);
        System.out.println(numTrees.next());
        System.out.println(numTrees.next());
        System.out.println(numTrees.hasNext());
        System.out.println(numTrees.next());
        System.out.println(numTrees.hasNext());
        System.out.println(numTrees.next());
        System.out.println(numTrees.hasNext());
        System.out.println(numTrees.next());
        System.out.println(numTrees.hasNext());
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
