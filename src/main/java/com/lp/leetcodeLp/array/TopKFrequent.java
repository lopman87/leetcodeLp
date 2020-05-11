package com.lp.leetcodeLp.array;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.freques - o1.freques;
            }
        });
        map.forEach((kk,vv)->{
            priorityQueue.add(new Pair(kk,vv));
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().val;
        }
        return result;
    }

    private static class Pair implements Comparable<Pair>{
        int val;
        int freques;
        Pair(int val , int freques){
            this.val = val;
            this.freques = freques;
        }

        @Override
        public int compareTo(Pair o) {
            return this.freques - o.freques;
        }
    }

    public static void main(String[] args){
        TopKFrequent cache = new TopKFrequent();
        int[] nums = {1,1,1,2,2,3,3,3,3};
        System.out.println(Arrays.toString(cache.topKFrequent(nums , 2)));
    }
}
