package com.leetcode.array;

/**
 * @author: yhl
 * @DateTime: 2019/11/12 15:23
 * @Description:
 */
public class SellStock {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 8};
        final SellStock sellStock = new SellStock();
        final int i = sellStock.maxProfit3(arr);
        System.out.println(i);
    }

    /**
     * brute force
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;
    }

    /**
     * One Pass
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxprofit){
                maxprofit = prices[i] - minPrice;
            }
        }
        return maxprofit;
    }

    /**
     * dp
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if(prices.length<2) return 0;
        int minPrice = prices[0];
        int temp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= minPrice) {
                temp = Math.max(temp, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }
        return temp;
    }


}