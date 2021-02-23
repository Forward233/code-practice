package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/22 9:50
 * @Description: 三数之和
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0};
//        int[] arr = {-1,0,1,2,-1,-4};
//        [-1,0,1,2,-1,-4]
//        输出：
//        [[-1,-1,2]]
//        预期：
//        [[-1,-1,2],[-1,0,1]]
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(arr);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = length - 1;
            while (start < end) {
                // 去重  重点 难点
                while (start > i + 1 && start < length && nums[start] == nums[start - 1]) {
                    start++;
                }
                if (start >= end) {
                    break;
                }
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ans;
    }

    /**
     * 有问题 需优化
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start;
        int end = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            start = i + 1;
            while (start > i + 1 && start < nums.length && nums[start] == nums[start - 1]) {
                start++;
            }

            if (start >= end) {
                break;
            }
            while (start < end) {
                if (nums[i] + nums[start]+ nums[end] < target) {
                    start++;
                } else if (nums[i] + nums[start]+ nums[end] > target) {
                    end--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                }
            }
        }
        return result;
    }

}

