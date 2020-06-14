package com.sort;


import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/15 11:42
 * Description: 简单选择排序的基本思想：给定数组：int[] arr={里面n个数据}；
 * 第1趟排序，在待排序数据arr[1]~arr[n]中选出最小的数据，将它与arrr[1]交.换；
 * 第2趟，在待排序数据arr[2]~arr[n]中选出最小的数据，将它与r[2]交换；
 * 以此类推，第i趟在待排序数据arr[i]~arr[n]中选出最小的数据，将它与r[i]交换，直到全部排序完成。
 */
public class SelectSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        select5(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[j]) {
                    //记录每趟最小值的索引，不用每次进行交换
                    j = k;
                }
            }
            // 交换
            if (i != j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 每日一练
     * 1.遍历数组
     * 2.记录每个循环的元素索引
     * 3.从此元素向后遍历，直到找出比此元素小的最小元素索引，替换本次循环元素
     * 4.如果此元素不为最小元素,将此元素和最小元素进行交换
     * 5.下一轮
     * @param arr
     */

    public static void select2(int[] arr) {
        for(int i = 0;i< arr.length;i++){
            int j = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[j]) {
                    j = k;
                }
            }
            // swap
            swap(arr, i, j);
        }
    }

    public static void select3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[j]) {
                    j = k;
                }
            }
            swap(arr, i, j);
        }
    }

    public static void select4(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[j]) {
                    j = k;
                }
            }
            swap(arr, i, j);
        }
    }

    // 找出为排序中最小的元素
    public static void select5(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[j]) {
                    j = k;
                }
            }
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    public static void select6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[j]) {
                    j = k;
                }
            }
            if (j != i) {

            }
        }
    }

    public static void select6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[j]) {
                    j = k;
                }
            }
            if (j != i) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
