package com.lp.leetcodeLp.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        buildSum(candidates,target,stack,res );
        return res;
    }

    private void buildSum (int[] candidates, int target , Deque<Integer> path, List<List<Integer>> res){
        if (target == 0){
            List<Integer> sss = new ArrayList<>(path).stream().sorted(Integer::compareTo).collect(Collectors.toList());
            if (!res.contains(sss)){
                res.add(sss);
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (target-candidates[i] < 0){
                continue;
            }
            path.add(candidates[i]);
            buildSum(candidates, target-candidates[i],path, res);
            path.removeLast();
        }
    }


    public static void main(String[] args){

        CombinationSum cache = new CombinationSum();
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(cache.combinationSum(candidates , target));

    }
}
