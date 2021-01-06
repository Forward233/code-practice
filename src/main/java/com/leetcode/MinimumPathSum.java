package com.leetcode;

/**
 * @author: yhl
 * @DateTime: 2021/1/5 14:24
 * @Description:
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int minPathSum = new MinimumPathSum().minPathSum(grid);
        System.out.println(minPathSum);
    }

    public int minPathSum(int[][] grid) {
        int high = grid.length;
        int width = grid[0].length;
        for(int i = 1 ;  i < high; i ++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i = 1 ;  i < width; i ++){
            grid[0][i] += grid[0][i-1];
        }
        for(int i = 1;i<high;i++){
            for(int j = 1;j<width;j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[high-1][width-1];
    }

}
