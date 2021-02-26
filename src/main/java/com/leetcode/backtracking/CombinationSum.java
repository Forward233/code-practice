package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 17:26
 * @Description:
 */
public class CombinationSum {

    public static void main(String[] args) {
        //candidates = [2,3,6,7], target = 7
        int[] candidates = {2, 3, 6, 7};
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(candidates, 7);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, path, res);
        return res;
    }


    private void dfs(int[] candidates, int target, int sum, List<Integer> path, List<List<Integer>> res) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            dfs(candidates, target, sum, path, res);
            path.remove(path.size() - 1);
        }
    }
}
