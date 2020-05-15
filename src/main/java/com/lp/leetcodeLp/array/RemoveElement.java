package com.lp.leetcodeLp.array;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                for (int j = nums.length-1; j > i ; j--) {
                    if (nums[j] != val){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                return i;
            }
        }
        return nums.length;
    }


    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> integerList = new ArrayList<>();
        if (A == null || A.length == 0){
            String a = K +"";
            char[] chars = a.toCharArray();
            for (char aaa: chars ) {
                integerList.add( (int) aaa);
            }
            return integerList;
        }
        StringBuilder stringBuilder = new StringBuilder( A.length);
        for (int aaaa:A) {
            stringBuilder.append(aaaa);
        }
        java.math.BigDecimal left = new java.math.BigDecimal(stringBuilder.toString());

        BigDecimal resVal = left.add(new BigDecimal(K));
        String a = resVal.toString();
        char[] chars = a.toCharArray();
        for (char aaa: chars ) {
            integerList.add(Character.getNumericValue(aaa));
        }
        return integerList;
    }

    public int[] plusOne(int[] A) {
        if (A == null || A.length == 0){
            return A;
        }
        StringBuilder stringBuilder = new StringBuilder( A.length);
        for (int aaaa:A) {
            stringBuilder.append(aaaa);
        }
        java.math.BigDecimal left = new java.math.BigDecimal(stringBuilder.toString());
        BigDecimal resVal = left.add(new BigDecimal(1));
        String aaaa = resVal.toString();
        char[] chars = aaaa.toCharArray();

        int[] result = new int[chars.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Character.getNumericValue(chars[i]);
        }
        return result;
    }


    public String multiply(String num1, String num2) {
        if (num1 == null || "".equals(num1))return num2;
        if (num2 == null || "".equals(num2))return num1;
        java.math.BigDecimal left = new java.math.BigDecimal(num1);
        return left.multiply(new java.math.BigDecimal(num2)).toString();
    }


    public String addStrings(String num1, String num2) {
        if (num1 == null || "".equals(num1))return num2;
        if (num2 == null || "".equals(num2))return num1;
        java.math.BigDecimal left = new java.math.BigDecimal(num1);
        return left.add(new java.math.BigDecimal(num2)).toString();
    }

    public static void main(String[] args){
        RemoveElement cache = new RemoveElement();
        int[] nums = {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};

        System.out.println(Integer.toBinaryString(7));
    }
}
