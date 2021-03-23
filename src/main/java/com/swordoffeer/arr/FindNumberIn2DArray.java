package com.swordoffeer.arr;

/**
 * @author: yhl
 * @DateTime: 2021/3/23 5:05
 * @Description: 二维数组中的查找
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5}};
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(matrix, 3));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        // 查找次数，从对角线开始查询行和列
        int n = matrix[0].length;
        int shortDim = Math.min(m, n);
        for (int i = 0; i < shortDim; i++) {
            boolean binarySearchRow = binarySearchRow(matrix, i, target);
            boolean binarySearchCol = binarySearchCol(matrix, i, target);
            if (binarySearchRow || binarySearchCol) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearchRow(int[][] matrix,
                                    int row, int target) {
        int lo = row;
        // 行数
        int hi = matrix[0].length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    private boolean binarySearchCol(int[][] matrix,
                                    int col, int target) {

        int lo = col;
        // 列数
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(matrix[mid][col] == target){
                return true;
            } else if (matrix[mid][col] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
