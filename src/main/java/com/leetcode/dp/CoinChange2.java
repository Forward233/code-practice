package com.leetcode.dp;

/**
 * @author: yhl
 * @DateTime: 2021/3/13 13:40
 * @Description: 硬币兑换II 回溯超出时间限制
 */
public class CoinChange2 {
    public static void main(String[] args) {
        //amount = 5, coins = [1, 2, 5]
        int amount = 100;
        int[] coins = {99, 1};
        CoinChange2 coinChange2 = new CoinChange2();
        int change = coinChange2.change(amount, coins);
        System.out.println(change);
    }


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 循环硬币
        for (int coin : coins) {
            for (int i = 0; i + coin <= amount; i++) {
                dp[i + coin] = dp[i + coin] + dp[i];
            }
        }
        return dp[amount];
    }

}
