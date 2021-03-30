package com.leetcode.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/3/30 15:06
 * @Description:
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // 12345
        for (int i = 0; i < nums.length - 3; i++) {
            int l = i + 2;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[i + 1] + nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[i + 1], nums[l], nums[r]));
                }

            }
        }
        return res;
    }
}
