package com.leetcode.greedy;

/**
 * @author: yhl
 * @DateTime: 2021/3/21 0:13
 * @Description: 跳跃游戏II
 */
public class Jump {

    public static void main(String[] args) {
        int[] nums = {5,2,1,1,1,3,4};
        System.out.println(new Jump().jump(nums));
    }

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
