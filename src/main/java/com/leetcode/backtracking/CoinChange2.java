package com.leetcode.backtracking;

import java.util.Arrays;

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
        Arrays.sort(coins);
        dfs(amount, coins, 0, 0);
        return count;
    }

    public int count;
    private void dfs(int amount, int[] coins, int begin, int sum) {
        if (sum == amount) {
            count++;
            return;
        }
        for (int i = begin; i < coins.length; i++) {
            if (sum + coins[i] > amount) {
                return;
            }
            sum += coins[i];
            dfs(amount, coins, i, sum);
            sum -= coins[i];
        }
    }
}
