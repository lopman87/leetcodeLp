package com.lp.leetcodeLp.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToStep {
    private Map<Integer, Integer> waysMap = new HashMap<>();
    public int waysToStep(int n) {
        int one = 1; //1
        int two = 1; //1+1 0+2
        int three = 0; //1+1+1+1 0+2+1 1+2+1 2+1+1
        int mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            int tmp1 = one;
            one = ((one + two) % mod + three)% mod;
            three = two;//1
            two = tmp1;//1
        }
        return one;

    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        WaysToStep numTrees = new WaysToStep();
        System.out.println(numTrees.waysToStep(900750));
        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end - start) );
    }
}
