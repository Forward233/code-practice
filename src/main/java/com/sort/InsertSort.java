package com.sort;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/14 15:31
 * Description:
 * 直接插入排序的基本操作是将一个记录插入到已经排好的有序表中，
 * 从而得到一个新的、记录数增1的有序表。对于给定的一组记录，初始时假定第一个记录自成一个有序序列，
 * 其余记录为无序序列。接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，
 * 直到最后一个记录插到有序序列中为止。
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        insertSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 核心思想，取出一个数放在外部缓存，将数组里的这个数的位置作为数组内部缓存使用
     * @param arr
     * @param length
     */
    private static void insertSort(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            // 记录每次待插入的元素
            int temp = arr[i];
            // 已经排好序数组的最大下标
            int j = i - 1;
            // 从后向前比较，小于
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    private static void insertSort1(int[] a, int length) {
        int i, j;
        for (i = 1; i < a.length; i++) {
            int temp = a[i];
            // for循环可以写成while
            for (j = i - 1; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }
}
