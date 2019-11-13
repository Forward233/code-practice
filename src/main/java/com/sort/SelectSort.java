package com.sort;


import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/15 11:42
 * Description: write some description
 */
public class SelectSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        selectSort(arr,  arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr, int i) {
        for (int j = 0; j < i; j++) {
            for (int k = j + 1; k < i; k++) {
                if (arr[j] > arr[k]) {
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                }
            }
        }
    }

}
