package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 22:48
 * @Description: 组合总和II
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        //candidates = [10,1,2,7,6,1,5], target = 8,
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2.combinationSum2(candidates, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, res, path);
        return res;
    }

    private void dfs(int[] candidates, int begin, int sum, int target,
                     List<List<Integer>> res, List<Integer> path) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] > target - sum) {
                return;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, i + 1, sum + candidates[i], target, res, path);
            path.remove(path.size() - 1);
        }
    }
}
