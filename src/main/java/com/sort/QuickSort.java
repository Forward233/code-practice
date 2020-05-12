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

        try {
            new QuickSort().testException();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("-------------");
        } catch (Exception e) {
            System.out.println("---------------------e");
        }
        System.out.println(Arrays.toString(arr));
    }


    void testException() throws NullPointerException{
        int[] a = new int[1];
        a[2] = 3;

    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left < right){
            int middle = compare(arr, left, right);
            quickSort(arr, left, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }

    private static int compare(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
