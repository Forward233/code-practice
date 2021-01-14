package com.sort;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2020/1/15 16:07
 * @Description:、桶排序适合小数量的小数据的排序，可以达到O(n)的时间复杂度， 比如对1千万个小于1亿的正整数排序
 */
public class BucketSort {


    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 9, 6, 8};
        bucketSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 给点的无序数组的范围确定
     *
     * @param arr
     */
    static void bucketSort(int[] arr) {
        int[] bucket = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[k++] = i;
            }
        }
    }

    static void bucketSort1(int[] arr) {
        int[] bucket = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[k++] = i;
            }
        }
    }
}
