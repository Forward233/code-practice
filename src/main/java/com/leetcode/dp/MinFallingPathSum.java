package com.leetcode.dp;

/**
 * @author: yhl
 * @DateTime: 2021/3/19 21:26
 * @Description: 下降路径最小和
 */
public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int res = new MinFallingPathSum().minFallingPathSum(matrix);
        System.out.println(res);
    }

    public int minFallingPathSum(int[][] matrix) {
//         [[2,1,3],      [[2,1,3],
//         [6,5,4],       [6,5,4],
//         [7,8,9]]       [7,8,9]]
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        System.arraycopy(matrix[0], 0, dp[0], 0, m);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else if (j == m - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + matrix[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;

    }
}
