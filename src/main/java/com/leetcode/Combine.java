package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 16:55
 * @Description:
 */
public class Combine {

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> result = combine.combine(4, 2);
        System.out.println(result);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, res, path);
        return res;
    }

    private void dfs(int n, int k, int begin, List<List<Integer>> res, List<Integer> path) {

        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}

