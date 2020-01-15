package com.sort;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2020/1/15 16:00
 * @Description:
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        int[] arrays = {4, 3, 2, 7, 6};
        mergeSort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }

    public static void mergeSort(int[] arr, int L, int R) {
        //如果只有一个元素，那就不用排序了
        if (L != R) {

            //取中间的数，进行拆分
            int M = (L + R) / 2;

            //左边的数不断进行拆分
            mergeSort(arr, L, M);

            //右边的数不断进行拆分
            mergeSort(arr, M + 1, R);

            //合并
            merge(arr, L, M + 1, R);
        }
    }

    public static void merge(int[] arr, int L, int M, int R) {
         int[] leftArray = new int[M - L];
        int[] rightArray = new int[R - M + 1];
        //往这两个数组填充数据
        if (M - L >= 0) System.arraycopy(arr, L, leftArray, 0, M - L);
        if (R + 1 - M >= 0) System.arraycopy(arr, M, rightArray, 0, R + 1 - M);

        int i = 0, j = 0;
        // arrays数组的第一个元素
        int  k = L;

        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {

            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arr[k] = rightArray[j];
            k++;
            j++;
        }
    }
}
