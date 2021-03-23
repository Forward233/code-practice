package com.sort;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/14 13:53
 * Description:
 * 分治
 * 1、先从数列中取出一个数作为基准数
 * 2、分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
 * 3、再对左右区间重复第二步，直到各区间只有一个数
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void quickSort(int[] arr, int left, int right) {
        // 左指针小于右指针
        if(left < right){
            // 排序
            int middle = compare(arr, left, right);
            // 二分 递归
            quickSort(arr, left, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }

    private static int compare(int[] arr, int left, int right) {
        // 基准
        int temp = arr[left];
        // 左指针小于右指针
        while (left < right) {
            // 找到右边比基准元素小的值
            while (left < right && arr[right] >= temp) {
                right--;
            }
            // 放在左边位置，右边位置空出来
            arr[left] = arr[right];
            // 找到左边比基准大的值
            while (left < right && arr[left] <= temp) {
                left++;
            }
            // 放在右边空出来的位置
            arr[right] = arr[left];
        }
        // 将基准元素放在合适的位置
        arr[left] = temp;
        // 返回索引位置
        return left;
    }
}
