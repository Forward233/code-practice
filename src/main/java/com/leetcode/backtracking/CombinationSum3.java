package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/27 0:04
 * @Description:  组合总和 III
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        List<List<Integer>> res = combinationSum3.combinationSum3(9, 45);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(k, n, 1, res, path);
        return res;
    }

    // 1-9 k个数的和为n的组合
    private void dfs(int k, int n, int begin, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == k && 0 == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= 9; i++) {
            path.add(i);
            dfs(k, n - i, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
