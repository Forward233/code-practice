package com.leetcode.array;

/**
 * @author: yhl
 * @DateTime: 2019/11/12 15:23
 * @Description:
 */
public class SellStock2 {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        final SellStock2 sellStock = new SellStock2();
        final int i = sellStock.maxProfit(arr);
        System.out.println(i);
    }

    /**
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

}