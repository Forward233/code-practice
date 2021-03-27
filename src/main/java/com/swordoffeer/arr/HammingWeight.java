package com.swordoffeer.arr;

/**
 * @author: yhl
 * @DateTime: 2021/3/28 1:43
 * @Description: 位1的个数
 */
public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(1>>>10);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;

    }
}
