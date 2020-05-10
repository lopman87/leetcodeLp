package com.lp.leetcodeLp.heap;

import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            int minJ = arr[0];
            int minJIndex = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < minJ){
                    minJ = arr[j];
                    minJIndex = j;
                }
            }
            if (minJ < arr[i]){
                int tmp = arr[i];
                arr[i] = minJ;
                arr[minJIndex] = tmp;
            }
        }
        return Arrays.copyOfRange(arr , arr.length-k , arr.length);
    }

    public static void main(String[] args){
        int k = 3;
        int[] arr = {4,5,8,2,9,7,1,4,3,0,6};
        SmallestK kthLargest = new SmallestK();
        System.out.println(Arrays.toString(kthLargest.smallestK(arr,3)));
    }
}
