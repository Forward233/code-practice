package com.leetcode.dp.backpack;

/**
 * @author: yhl
 * @DateTime: 2021/3/13 12:19
 * @Description:
 */
public class Knapsack01 {
    public static void main(String[] args) {
        // 物品个数
        int n = 4;
        // 背包容量
        int w = 6;
        int[] weight = {0,3, 1, 2, 4};    //各个物品的重量
        int[] value = {0, 6, 10, 5, 10};     //各个物品的价值
        Knapsack01 knapsack01 = new Knapsack01();
        int maxValue = knapsack01.getMaxValue(weight, value, w, n);
        System.out.println(maxValue);
    }

    public int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];

        // 物品个数
        for (int i = 1; i <= n; i++) {
            // 背包大小
            for (int j = 0; j <= w; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n][w];

    }
}
