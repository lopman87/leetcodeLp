package com.lp.leetcodeLp.tree;

import java.util.*;

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
        if (root == null){
            return integerList;
        }
        List<String> StringList = new ArrayList<>();
        levleVisit(root,StringList);
        for (String s: StringList) {
            String first =  s.substring(0 , s.indexOf("."));
            integerList.add(Integer.parseInt(first));
        }
        return integerList;
    }

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     *  
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> StringList = new ArrayList<>();;
        levleVisitList(root,StringList);
        return StringList;
    }

    private void levleVisitList(TreeNode root ,List<List<Integer>> StringList){
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.add(root);
        while (true){
            while (!nodeStack.isEmpty()){
                TreeNode topNode = nodeStack.poll();
                nodeQueue.add(topNode);
            }
            List<Integer> levelStr = new ArrayList<>();
            while (!nodeQueue.isEmpty()){
                TreeNode inQueue = nodeQueue.poll();
                if (inQueue == null)continue;
                levelStr.add(inQueue.val);
                if (inQueue.right != null){
                    nodeStack.add(inQueue.right);
                }
                if (inQueue.left != null){
                    nodeStack.add(inQueue.left);
                }

            }
            StringList.add(levelStr);
            if (nodeStack.isEmpty())break;
        }
    }

    private void levleVisit(TreeNode root ,List<String> StringList){
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.add(root);
        while (true){
            while (!nodeStack.isEmpty()){
                TreeNode topNode = nodeStack.poll();
                nodeQueue.add(topNode);
            }
            StringBuilder levelStr = new StringBuilder();
            while (!nodeQueue.isEmpty()){
                TreeNode inQueue = nodeQueue.poll();
                if (inQueue == null)continue;
                levelStr.append(inQueue.val+".");
                if (inQueue.right != null){
                    nodeStack.add(inQueue.right);
                }
                if (inQueue.left != null){
                    nodeStack.add(inQueue.left);
                }

            }
            StringList.add(levelStr.toString());
            if (nodeStack.isEmpty())break;
        }
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        RightSideView numTrees = new RightSideView();
        TreeNode root = new TreeNode(1);

        root.right=new TreeNode(2);

//        root.left.right = new TreeNode(5);
//
//        root.left.right.right = new TreeNode(15);
//
//
//        root.right= new TreeNode(3);
//        root.right.left= new TreeNode(51);
//        root.right.left.left= new TreeNode(151);
//
//        root.right.right = new TreeNode(4);
        System.out.println( numTrees.rightSideView(root));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
