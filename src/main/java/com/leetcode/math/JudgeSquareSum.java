package com.leetcode.math;

/**
 * @author: yhl
 * @DateTime: 2021/4/28 7:05
 * @Description: 平方数之和
 */
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int)Math.sqrt(c);

        while (a < b) {
            if (a * a + b * b < c) {
                a++;
            } else if (a * a + b * b > c) {
                b--;
            } else {
                return true;
            }
        }
        return false;
    }
}
