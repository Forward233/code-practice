package com.leetcode;

import java.util.Arrays;

/**
 * Author: yhl
 * DateTime: 2019/11/7 7:49
 * Description: write some description
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        PlusOne plusOne = new PlusOne();
        int[] newArr = plusOne.plusOne(arr);
        System.out.println(Arrays.toString(newArr));
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        while (length >= 0) {
            if (digits[length] < 9) {
                digits[length]++;
                return digits;
            }
            digits[length--] = 0;
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }
}
