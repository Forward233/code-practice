package com.leetcode.dp;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2021/3/28 1:28
 * @Description:
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[]  nums = {10,9,2,5,3,7,101,18};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        lengthOfLIS.lengthOfLISWithDichotomy(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int d : dp) {
            max = Math.max(d, max);
        }
        return max;
    }

    public int lengthOfLISWithDichotomy(int[] nums) {
        /**
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         **/
        int maxL = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0;
            int hi = maxL;
            while (lo < hi) {
                int mid = (hi + lo) / 2;
                if (dp[mid] < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            dp[lo] = num;
            if (lo == maxL) {
                maxL++;
            }
        }
        return maxL;
    }

}
