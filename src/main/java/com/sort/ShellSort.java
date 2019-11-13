package com.sort;


/**
 * Author: yhl
 * DateTime: 2019/10/16 10:04
 * Description: write some description
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        System.out.println();
        ShellSort shellSort = new ShellSort();

        for (int i = 0; i < 50_000; i++) {
            shellSort.test();
        }
    }

    private static void shellSort(int[] arr, int length) {

    }
    private void test() {
        int i = 8;
        while ((i -= 3) > 0);
        System.out.println("i = " + i);
    }
}
