package com.sort;


import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/16 10:04
 * Description: 缩小增量排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j] < arr[j - gap]) {
                    //插入排序采用交换法
                    int temp = arr[j - gap];
                    arr[j - gap] = arr[j];
                    arr[j] = temp;
                    j -= gap;
                }
            }
        }
    }

    private static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap > 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
