package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 17:26
 * @Description: 组合总和
 */
public class CombinationSum {

    public static void main(String[] args) {
        //candidates = [2,3,6,7], target = 7
        int[] candidates = {2,3,6,7};
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, 7);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        // 排序是重点，如果加上当前元素，超过target，那么就不用考虑下一位元素了，直接撤消两位
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, 0, path, res);
        return res;
    }


    private void dfs(int[] candidates, int begin, int target, int sum, List<Integer> path,
                     List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 必须结束循环
            if (candidates[i] > target - sum) {
                return;
            }
            if (i > 0 && candidates[i-1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, i, target, sum, path, res);
            // 重点 撤消操作
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
