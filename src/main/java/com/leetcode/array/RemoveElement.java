package com.leetcode.array;

/**
 * Author: yhl
 * DateTime: 2019/11/4 17:21
 * Description: write some description
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 2, 3, 4, 4, 4};
        final int i = new RemoveElement().removeElement1(arr, 2);
        System.out.println(i);
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                i++;
            }
        }
        return i;
    }
}
