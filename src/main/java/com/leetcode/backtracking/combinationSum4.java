package com.leetcode.backtracking;

/**
 * @author: yhl
 * @DateTime: 2021/4/24 20:05
 * @Description:
 */
public class combinationSum4 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int target = 4;
        combinationSum4 combinationSum4 = new combinationSum4();
        int result = combinationSum4.combinationSum4WithDp(nums, target);
        System.out.println(result);
    }


    int count;

    public int combinationSum4(int[] nums, int target) {
        dfs(nums, 0, target);
        return count;
    }

    private void dfs(int[] nums, int sum, int target) {
        if (sum >= target) {
            if (sum == target) {
                count++;
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dfs(nums, sum, target);
            sum -= nums[i];
        }
    }

//    int[] nums = {3, 1, 2, 4};
//    int target = 4;
    public int combinationSum4WithDp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
