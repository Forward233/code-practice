package com.algorithm.dynamic;

import java.util.Scanner;

/**
 * Author: yhl
 * DateTime: 2020/1/14 22:16
 * Description: write some description
 */
public class PascalTriangle {

    /**
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        System.out.println(dp[0][0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
