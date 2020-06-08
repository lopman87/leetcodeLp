package com.lp.leetcodeLp.dp;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLength {



    public int findLength(int[] A, int[] B) {
        int len_a = A.length;
        int len_b = B.length;

        int[][] len_Array = new int[len_a][len_b];
        int res=0;
        for(int i=0;i<len_a;i++) {
            if(A[i]==B[0]) {res=1;len_Array[i][0]=1;}
        }
        for(int j=1;j<len_b;j++) {
            if(A[0]==B[j]) {res=1;len_Array[0][j]=1;}
        }
        for (int i = 1; i < len_a; i++) {
            for (int j = 1; j < len_b; j++) {
                if (A[i] == B[j]){
                    len_Array[i][j] = len_Array[i-1][j-1]+1;
                    if(len_Array[i][j]>res) res=len_Array[i][j];
                }else {
                    len_Array[i][j] = 0;
                }
            }
        }

        return res;
    }


    public static void main(String args[]){
        FindLength numTrees = new FindLength();
        int[] A = {0,1,1,1,1};
        int[] B = {1,0,1,0,1};
        System.out.println(numTrees.findLength(A,B ));
    }
}
