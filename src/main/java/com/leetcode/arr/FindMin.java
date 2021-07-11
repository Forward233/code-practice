package com.leetcode.arr;

/**
 * @author: yhl
 * @DateTime: 2021/4/8 10:30
 * @Description:
 */
public class FindMin {

    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int middle = low + (high - low) >> 1;
            if (nums[middle] < nums[high]) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return nums[low];
    }
}
