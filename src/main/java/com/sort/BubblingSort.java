package com.sort;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/14 13:41
 * Description: write some description
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        bubblingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubblingSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 数组的长度为length,下面运算只能有下标+1操作，
            // 所以下标的最大值应为length-1-1（下标从0开始）
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
