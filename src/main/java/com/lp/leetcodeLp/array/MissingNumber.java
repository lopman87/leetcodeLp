package com.lp.leetcodeLp.array;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null||nums.length==0){
            return 0;
        }
        int lengh = nums.length;
        int sum = lengh*(lengh+1)/2;
        int sum2 = 0;
        for (int a:nums) {
            sum2+=a;
        }
        return sum-sum2;
    }

    public static void main(String[] args){

        MissingNumber cache = new MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(cache.missingNumber(nums));
    }
}
