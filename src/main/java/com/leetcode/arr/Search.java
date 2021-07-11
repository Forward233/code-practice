package com.leetcode.arr;

/**
 * @author: yhl
 * @DateTime: 2021/4/7 9:53
 * @Description:
 */
public class Search {

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return true;
                }

                while (left <= mid && nums[left] == nums[mid]) {
                    left++;
                }
                if (left > mid) {
                    left = mid + 1;
                    continue;
                }

                if (nums[left] < nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }

                } else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

            }
        }
        return false;
    }
}