package com.lp.leetcodeLp.array;


/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *  
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0d;
        if (nums1==null && nums2 ==null){
            return result;
        }
        int[] both = null;
        if (nums1 == null && nums2 != null){
            both = nums2;
        }else if (nums1 != null && nums2 == null){
            both = nums1;
        }else if (nums1 != null && nums2 != null){
            both = java.util.Arrays.copyOf(nums1, nums1.length + nums2.length);
            System.arraycopy(nums2, 0, both, nums1.length, nums2.length);
            java.util.Arrays.sort(both);
        }

        if (both.length % 2 == 0){
            double q1 = (double)both[both.length/2];
            double q2 = (double)both[both.length/2-1];
            result = (q1 + q2)/2d;
        }else{
            result = (double)both[both.length/2];
        }
        return result;
    }

    public static void main(String[] args){
        FindMedianSortedArrays cache = new FindMedianSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(cache.findMedianSortedArrays(nums1,nums2));
    }
}
