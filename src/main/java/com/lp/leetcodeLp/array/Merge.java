package com.lp.leetcodeLp.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int element2 = nums2[i];
            nums1[nums1.length -1 -i] = element2;
        }

        Comparator<Integer> employeeNameComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                if (e1 != 0 && e2 != 0) {
                    return e1.compareTo(e2);
                } else {
                    return e1 == 0 ? 1 : -1;
                }
            }
        };

        Integer[] ever = IntStream.of( nums1 ).boxed().toArray( Integer[]::new );

        Arrays.sort(ever, employeeNameComparator);

        for (int i = 0; i < ever.length; i++) {
            nums1[i] = ever[i];
        }

    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0,0};
        int[] nums2 = {2,5,6};
        Merge cache = new Merge();
        cache.merge(nums1 , 3 , nums2 ,3);

        System.out.println(Arrays.toString(nums1));
    }
}
