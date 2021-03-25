package com.swordoffeer.arr;

/**
 * @author: yhl
 * @DateTime: 2019/11/11 17:33
 * @Description: 合并两个有序数组
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int last = m + n - 1;
        while (n > 0) {
            // nums1 < nums2
            if (m == 0 || nums1[m - 1] <= nums2[n - 1]) {
                nums1[last--] = nums2[--n];
            } else {
                //nums1 > nums2 nums2最大的比nums小，nums1的元素放在最后
                nums1[last--] = nums1[--m];
            }
        }
    }

}
