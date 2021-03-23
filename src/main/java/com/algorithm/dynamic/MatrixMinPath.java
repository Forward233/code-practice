package com.algorithm.dynamic;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/18 14:54
 * Description: 矩阵最短路径
 */
public class MatrixMinPath {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minPath2(arr));
    }

    private static int minPath(int[][] arr) {
        if (arr.length == 0) {
            return 0;
        }

        // 行
        int rows = arr.length;
        // 列
        int columns = arr[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i < arr[0].length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }


        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <arr[0].length ; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[arr.length-1][arr[0].length-1];
    }

    /**
     * optimize
     * @param arr
     * @return
     */
    private static int minPath2(int[][] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0][0];
        for (int i = 1; i < arr[0].length; i++) {
            // 求出第一行的dp
            dp[i] = dp[i - 1] + arr[0][i];
        }
        System.out.println(Arrays.toString(dp));
        // 行遍历
        for (int i = 1; i < arr.length; i++) {
            // 计算出第一个数
            dp[0] = dp[0] + arr[i][0];
            // 列遍历
            for (int j = 1; j <arr[0].length ; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + arr[i][j];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[arr[0].length-1];
    }

}
