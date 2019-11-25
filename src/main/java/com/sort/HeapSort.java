package com.sort;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/10/15 15:02
 * Description:
 * refrenece：[堆排序算法（图解详细流程） - 阿顾的博客 - CSDN博客](https://blog.csdn.net/u010452388/article/details/81283998#commentsedit)
 * 大根堆和小根堆:
 *      性质：每个结点的值都大于其左孩子和右孩子结点的值，称之为大根堆；每个结点的值都小于其左孩子和右孩子结点的值，称之为小根堆
 *      1.父结点索引：(i-1)/2（这里计算机中的除以2，省略掉小数）
 *      2.左孩子索引：2*i+1
 *      3.右孩子索引：2*i+2
 *      所以上面两个数组可以脑补成堆结构，因为他们满足堆的定义性质：
 *      大根堆：arr(i)>arr(2*i+1) && arr(i)>arr(2*i+2)
 *      小根堆：arr(i)<arr(2*i+1) && arr(i)<arr(2*i+2)
 *
 *      基本思想：
 *      1.首先将待排序的数组构造成一个大根堆，此时，整个数组的最大值就是堆结构的顶端
 *      2.将顶端的数与末尾的数交换，此时，末尾的数为最大值，剩余待排序数组个数为n-1
 *      3.将剩余的n-1个数再构造成大根堆，再将顶端数与n-1位置的数交换，如此反复执行，便能得到有序数组
 *      将无序数组构造成一个大根堆（升序用大根堆，降序就用小根堆）
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 7, 8, 4, 3, 0, 2, 9};
        // 构建小堆顶
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
            // 父节点
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

    //将剩余的数构造成大根堆（通过顶端的数下降）
    private static void structuralHeap(int[] arr, int length){
        int index = 0;
        int leftChild = 1;
        int rightChild =  2;
        while (leftChild < length) {
            int largeIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (arr[leftChild] < arr[rightChild] && rightChild < length) {
                largeIndex = rightChild;
            } else {
                largeIndex = leftChild;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largeIndex]) {
                largeIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if(index == largeIndex){
                break;
            }
            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largeIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largeIndex;
            //重新计算交换之后的孩子的索引
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
