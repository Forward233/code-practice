package com.leetcode.math;

/**
 * @author: yhl
 * @DateTime: 2021/4/1 11:47
 * @Description:
 */
public class ConstructArr {

    public static void main(String[] args) {
        int[] a = {3, 2, 3, 4, 5};
        ConstructArr constructArr = new ConstructArr();
        constructArr.constructArr(a);
    }

    public int[] constructArr(int[] a) {

        int[] res = new int[a.length];
        int cur = 1;
        for (int i = 0; i < a.length; i++) {
            res[i] = cur;   // 先乘左边的数(不包括自己)
            cur *= a[i];
        }
        cur = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] *= cur;  // 再乘右边的数(不包括自己)
            cur *= a[i];
        }
        return res;
    }
}
