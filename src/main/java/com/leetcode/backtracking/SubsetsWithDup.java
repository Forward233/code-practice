package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/3/27 9:36
 * @Description:  子集II
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> res = subsetsWithDup.subsetsWithDup(nums);
        System.out.println(res);

    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums,int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }

    }
}
