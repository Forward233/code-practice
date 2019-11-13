package com.leetcode;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2019/11/13 14:22
 * @Description:
 */
public class TwoSum2 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 3, 4};
        final TwoSum2 twoSum2 = new TwoSum2();
        final int[] ints = twoSum2.twoSum2(arr, 7);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    /**
     * perfect answer
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (numbers[left] + numbers[right] != target) {
            if(numbers[left] + numbers[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
