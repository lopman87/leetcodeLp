package com.lp.leetcodeLp.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetLeastNumbers {

    private PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();

    public int[] getLeastNumbers(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            integerPriorityQueue.add(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = integerPriorityQueue.poll();
        }
        return res;
    }


    public static void main(String[] args){
        GetLeastNumbers cache = new GetLeastNumbers();
        int[] nums1 = {1,7 ,8,3};
        System.out.println(Arrays.toString(cache.getLeastNumbers(nums1,3)));
    }
}
