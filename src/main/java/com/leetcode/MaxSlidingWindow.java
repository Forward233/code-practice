package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/23 16:00
 * @Description:
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] ints = maxSlidingWindow.maxSlidingWindowWithDeque(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            int maxNum = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxNum = Math.max(maxNum, nums[j]);
            }
            result.add(maxNum);
        }
        return result.stream().mapToInt(r -> r).toArray();
    }

    public int[] maxSlidingWindowWithDeque(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.add(i);
            if (!queue.isEmpty() && queue.peek() < i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k && !queue.isEmpty()) {
                ans[i + 1 - k] = nums[queue.peek()];
            }
        }
        return ans;
    }
}