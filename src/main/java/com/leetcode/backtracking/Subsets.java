package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/27 10:53
 * @Description: 子集
 */
public class Subsets {

    public static void main(String[] args) {

//        输入：nums = [1,2,3]
//        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(subsets.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int begin, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        if (begin >= nums.length) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
