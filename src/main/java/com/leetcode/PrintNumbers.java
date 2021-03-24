package com.leetcode;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2021/3/23 17:17
 * @Description:
 */
public class PrintNumbers {

    public static void main(String[] args) {
        int[] res = new PrintNumbers().printNumbers(3);
        System.out.println(Arrays.toString(res));
    }

    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] res = new int[max - 1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
