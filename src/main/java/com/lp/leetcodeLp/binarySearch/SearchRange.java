package com.lp.leetcodeLp.binarySearch;

import java.util.Arrays;

/**
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = res[1] = -1;
        if (nums == null || nums.length == 0){
            return res;
        }
        if (nums.length == 1){
            if (nums[0] != target){
                return res;
            }else{
                res[0] = res[1] = 0;
                return res;
            }
        }
        if (target < nums[0] || target > nums[nums.length - 1]){
            return res;
        }
        int location = binarySearch(nums , target , 0 , nums.length - 1);
        if (location == -1){
            return res;
        }
        res[0] = findLeft(nums , target , location);
        res[1] = findRight(nums , target , location);
        return res;
    }

    int findLeft(int[] nums, int target ,int left){
        int index = left;
        for (int i = left; i >= 0 ; i--) {
            if (nums[i] == target){
                index = i;
            }else{
                break;
            }
        }
        return index;
    }
    int findRight(int[] nums, int target ,int right){
        int index = right;
        for (int i = right; i < nums.length; i++) {
            if (nums[i] == target){
                index = i;
            }else{
                break;
            }
        }
        return index;
    }

    int binarySearch(int[] nums, int target ,int left,int right){
        if (right - left <= 1){
            if (nums[left] == target){
                return left;
            }else if (nums[right] == target){
                return right;
            }else{
                return -1;
            }
        }
        if (nums[(left+right) / 2] == target){
            return (left+right) / 2;
        }else if (nums[(left+right) / 2] > target){
            return binarySearch(nums , target , left , (left+right) / 2);
        }else {
            return binarySearch(nums , target , (left+right) / 2 , right);
        }
    }

    public static void main(String[] args){

        SearchRange cache = new SearchRange();
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(cache.searchRange(nums,2)));
    }
}
