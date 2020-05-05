package com.lp.leetcodeLp.tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)return null;
        if (nums.length == 1)return new TreeNode(nums[0]);
        if (nums.length == 2){
            TreeNode root = new TreeNode(nums[0]);
            root.right = new TreeNode(nums[1]);
            return root;
        }
        TreeNode root = buildTree(nums ,0 , nums.length-1);
        return root;
    }

    private TreeNode buildTree(int[] nums, int leftIndex , int rightIndex){

        int flag = (leftIndex+rightIndex)/2;

        TreeNode root = new TreeNode(nums[flag]);
        if (leftIndex == rightIndex){
            return root;
        }
        if (rightIndex-leftIndex <=1){
            root.right = new TreeNode(nums[flag+1]);
            return root;
        }
        root.left = buildTree(nums,leftIndex,flag-1);
        root.right = buildTree(nums,flag+1,rightIndex);
        return root;
    }




    public static void main(String[] args){
        SortedArrayToBST cache = new SortedArrayToBST();
        int[] nums = {-1,0,1,2};
        System.out.println(cache.sortedArrayToBST(nums));
    }
}
