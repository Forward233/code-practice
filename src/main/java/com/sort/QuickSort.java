package com.sort;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/14 13:53
 * Description:
 * 分治
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 左边的元素小于left基准值，右边的元素大于基准值
            int point = partion(arr, left, right);
            quickSort(arr, left, point - 1);
            quickSort(arr, point + 1, right);
        }
    }

    private static int partion(int[] arr, int left, int right) {
        // 比较基准值
        int temp = arr[left];
        while (left < right) {
            //先从右开始，找到一个比arr[left]小的
            while (left < right && temp <= arr[right]) {
                right--;
            }
            // 找到之后
            arr[left] = arr[right];
            // 在从左开始，找到一个比arr[left]大的
            while (left < right && temp >= arr[left]) {
                left++;
            }
            // 找到之后，即left与right已经互换
            arr[right] = arr[left];
        }
        // 将left替换为基准轴
        arr[left] = temp;
        return left;
    }
}
