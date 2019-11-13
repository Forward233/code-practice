package com.sort;

/**
 * Author: yhl
 * DateTime: 2019/10/14 13:53
 * Description: write some description
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int point = partion(arr, left, right);
            quickSort(arr, left, point - 1);
            quickSort(arr, point + 1, right);
        }
    }

    private static int partion(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && temp <= arr[right]) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && temp >= arr[left]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
