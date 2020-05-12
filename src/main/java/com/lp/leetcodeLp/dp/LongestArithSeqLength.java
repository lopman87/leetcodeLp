package com.lp.leetcodeLp.dp;

/**
 * 定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 *
 * 示例 1：
 *
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 *
 * 输入：[9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 *
 * 输入：[20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-arithmetic-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestArithSeqLength {


    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0)return 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int chazhi = A[i] - A[j];
                int start = j-1;
                int startVal = A[j];
                for (; start >=0 ; start--) {
                    if (( startVal - A[start] ) == chazhi){
                        System.out.println(A[start]);
                        startVal = A[start];
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String args[]){
        long start = System.currentTimeMillis();
        LongestArithSeqLength numTrees = new LongestArithSeqLength();
        int[] A = {20,1,15,3,10,5,8};
        System.out.println(numTrees.longestArithSeqLength(A));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
