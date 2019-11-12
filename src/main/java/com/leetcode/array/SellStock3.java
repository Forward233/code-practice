package com.leetcode.array;

/**
 * @author: yhl
 * @DateTime: 2019/11/12 15:23
 * @Description:
 */
public class SellStock3 {

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        final SellStock3 sellStock = new SellStock3();
        final int i = sellStock.maxProfit(arr);
        System.out.println(i);
    }

    /**
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE,
                    sale1 = 0, sale2 = 0;
//        buy1 = max(buy1, -i);
//        sell1 = max(sell1, buy1 + i);
//        buy2 = max(buy2, sell1 - i);
//        sell2 = max(sell2, buy2 + i);
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sale1 = Math.max(sale1, buy1 + price);
            buy2 = Math.max(buy2, sale1 - price);
            sale2 = Math.max(sale2, buy2 + price);
        }
        return sale2;
    }

}