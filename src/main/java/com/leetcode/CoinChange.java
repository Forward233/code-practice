package com.leetcode;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2021/2/24 14:49
 * @Description: 硬币兑换
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
