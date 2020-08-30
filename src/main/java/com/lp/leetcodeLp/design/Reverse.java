package com.lp.leetcodeLp.design;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse {



    public int reverse(int x) {
        if (x > 0 ){
            return doReverse(x);
        }else if (x < 0){
            return -1 * doReverse(Math.abs(x));
        }else{
            return 0;
        }
    }

    private int doReverse(int x){
        List<Character> aa = String.valueOf(x).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.reverse(aa);
        Object[] characters = aa.toArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            stringBuilder.append((char)characters[i])  ;
        }
        String str = stringBuilder.toString();
        try {
            return Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }

    }


    public static void main(String[] args){
        Reverse queue = new Reverse();
        System.out.println(queue.reverse(10));   // 返回 1
        System.out.println(queue.reverse(-32)); // 返回 false

    }
}
