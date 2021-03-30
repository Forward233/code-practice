package com.leetcode.arr;

/**
 * @author: yhl
 * @DateTime: 2021/3/24 7:16
 * @Description:
 */
public class Reverse {
    public static void main(String[] args) {

    }

    public int reverse(int x) {
        long res = 0L;
        while (x != 0) {
            res = res * 10 + res % 10;
            x /= 10;
        }
        return (int) res == res ? (int)res : 0;
    }
}
