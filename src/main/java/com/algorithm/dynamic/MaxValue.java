package com.algorithm.dynamic;

/**
 * @author: yhl
 * @DateTime: 2021/3/11 15:42
 * @Description:
 */
public class MaxValue {

    public static void main(String[] args) {
//          [1,3,1],
//          [1,5,1],
//          [4,2,1]
        MaxValue maxValue = new MaxValue();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue.maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < column; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }
}
