package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 16:26
 * @Description:全排列II
 */
public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 3};
        PermuteUnique permute = new PermuteUnique();
        List<List<Integer>> result = permute.permuteUnique(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        int length = nums.length;
        boolean[] used = new boolean[length];
        dfs(nums, length, 0, path, res, used);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, List<List<Integer>> res, boolean[] used) {

        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (!used[i]) {
                // 剪枝
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, res, used);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
