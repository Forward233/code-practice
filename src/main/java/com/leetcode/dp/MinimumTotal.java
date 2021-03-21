package com.leetcode.dp;

import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/3/19 10:07
 * @Description:
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int len = triangle.size();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            List<Integer> sub = triangle.get(i);
            for (int j = 0; j < sub.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + sub.get(j);
            }
        }
        return dp[0][0];
    }
}
