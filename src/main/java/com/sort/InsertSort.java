package com.sort;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/14 15:31
 * Description:
 * 直接插入排序的基本操作是将-一个记录插入到已经排好的有序表中，
 * 从而得到一个新的、记录数增1的有序表。对于给定的一组记录，初始时假定第一个记录自成一个有序序列，
 * 其余记录为无序序列。接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，
 * 直到最后一个记录插到有序序列中为止。
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        insert4(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 核心思想，取出一个数放在外部缓存，将数组里的这个数的位置作为数组内部缓存使用
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];
            // 当前元素的前一个元素
            int j = i - 1;
            // 如果前一个元素大于当前元素，与当前元素交换位置
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
//            // 记录每次待插入的元素
//            int temp = arr[i];
//            // 已经排好序数组的最大下标
//            int j = i - 1;
//            // 从后向前比较，小于
//            while (j >= 0 && arr[j] > temp) {
//                arr[j + 1] = arr[j];
//                j--;
//            }
//            arr[j+1] = temp;
        }
    }

    private static void insertSort1(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            // for循环可以写成while
            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }

    /**
     * 每天一练
     * 取第一个元素做为一个有序数组，从后面的数组中找出比此元素小的
     */
    private static void insert2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 因为循环中的j--，所以这块要+1
            arr[j + 1] = temp;
        }
    }

    public static void insert3(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i ++) {
            // 记录要插入的元素
            int temp = arr[i];
            // 记录排好序的数组最后一个元素索引\
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    public static void insert4(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void insert5(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

}
