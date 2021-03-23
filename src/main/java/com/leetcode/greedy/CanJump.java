package com.leetcode.greedy;

/**
 * @author: yhl
 * @DateTime: 2021/3/20 15:20
 * @Description: 跳跃游戏
 */
public class CanJump {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new CanJump().canJump(nums));
    }

    // 只要能跳过0，不会跳到0上，就会满足
    public boolean canJump(int[] nums) {
        int reach = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 如果没有调高当前索引，即为到不了终点
            if (i > reach) {
                return false;
            }
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }
}
