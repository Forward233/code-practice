package com.leetcode;

/**
 * @author: yhl
 * @DateTime: 2019/11/12 15:23
 * @Description:
 */
public class SellStock3 {

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,4,1,4};
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
                    sell1 = 0, sells2 = 0;
//        buy1 = max(buy1, -i);
//        sell1 = max(sell1, buy1 + i);
//        buy2 = max(buy2, sell1 - i);
//        sell2 = max(sell2, buy2 + i);
        //3,3,5,0,0,3,4,1,4
        for (int price : prices) {
            // if lower than before,buy it
            buy1 = Math.max(buy1, -price);
            // if higher than before sell,sell and replace it
            sell1 = Math.max(sell1, buy1 + price);
            // note current money
            buy2 = Math.max(buy2, sell1 - price);
            // after sell, max money
            sells2 = Math.max(sells2, buy2 + price);
        }
        return sells2;
    }

}