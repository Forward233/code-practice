package com.sort;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/15 15:02
 * Description: write some description
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        heapInsert(arr);
        int length = arr.length;
        while (length > 1) {
            swap(arr, 0, length - 1);
            length--;
            structuralHeap(arr, length);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentIndex = i;
            int fatherIndex = (currentIndex - 1) / 2;
            while (arr[currentIndex] > arr[fatherIndex]) {
                // 交换
                swap(arr, currentIndex, fatherIndex);
                // 当前索引指向父索引
                currentIndex = fatherIndex;
                // 重新计算当前索引的父索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    private static void structuralHeap(int[] arr, int length){
        int index = 0;
        int leftChild = 1;
        int rightChild =  2;
        while (leftChild < length) {
            int largeIndex;
            if (arr[leftChild] < arr[rightChild] && rightChild < length) {
                largeIndex = rightChild;
            } else {
                largeIndex = leftChild;
            }
            if (arr[index] > arr[largeIndex]) {
                largeIndex = index;
            }
            if(index == largeIndex){
                break;
            }
            swap(arr, largeIndex, index);
            index = largeIndex;
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
        }
    }

    private static void swap(int[] arr, int currentIndex, int fatherIndex) {
        int temp = arr[currentIndex];
        arr[currentIndex] = arr[fatherIndex];
        arr[fatherIndex] = temp;
    }
}
