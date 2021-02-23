package com.algorithm.recursion;

/**
 * @author: yhl
 * @DateTime: 2021/1/16 23:17
 * @Description:
 */
public class JumpStair {

    public static void main(String[] args) {

        /*
        * 1: 1
        * 2: 11、2
        * 3：111、12、21、
        * ...
        * */
        System.out.println(jumpStair(10));
        System.out.println(jumpStairWithDynamicPlan(10));
    }


    static int jumpStair(int stairNumber) {
        if (stairNumber <= 2) {
            return stairNumber;
        }
        return jumpStair(stairNumber - 1) + jumpStair(stairNumber - 2);
    }

    static int jumpStairWithDynamicPlan(int stairNumber) {
        int[] dp = new int[stairNumber];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < stairNumber; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairNumber - 1];
    }

}
