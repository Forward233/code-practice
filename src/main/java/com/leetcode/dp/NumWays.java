package com.leetcode.dp;

/**
 * @author: yhl
 * @DateTime: 2021/3/6 12:23
 * @Description:
 */
public class NumWays {

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(46));
    }

    public int numWays(int n) {
        if(n== 0) return 1;
        if(n == 1 || n ==2) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =2;i<dp.length;i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }

        return dp[n];
    }
}
