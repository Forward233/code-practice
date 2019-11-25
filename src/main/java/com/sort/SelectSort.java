package com.sort;


import org.checkerframework.checker.units.qual.K;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/15 11:42
 * Description: 简单选择排序的基本思想：给定数组：int[] arr={里面n个数据}；
 * 第1趟排序，在待排序数据arr[1]~arr[n]中选出最小的数据，将它与arrr[1]交换；
 * 第2趟，在待排序数据arr[2]~arr[n]中选出最小的数据，将它与r[2]交换；
 * 以此类推，第i趟在待排序数据arr[i]~arr[n]中选出最小的数据，将它与r[i]交换，直到全部排序完成。
 */
public class SelectSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        selectSort(arr);
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

}
