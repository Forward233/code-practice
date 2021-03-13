package com.algorithm.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yhl
 * @DateTime: 2021/3/7 14:38
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        //[1,3,5,2,4],[1,2,3,4,5]
        int[] arr = {1,3,5,2,4};
        int[] arr1 = {1,2,3,4,5};
        int maxValue = new Test().getMaxValue2(arr, arr1);
        System.out.println(maxValue);
    }

    public int getMaxValue(int[] nums, int[] values) {
        // write code here
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = nums[i] * values[j];
            }
        }
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += dp[i][i];
        }
        int sum2 = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            sum2 += dp[i][j];
        }
        return Math.max(sum1, sum2);
    }

    public int getMaxValue2(int[] nums, int[] values) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(i, values[i]);
        }
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = nums.length - 1;
            int sum = 0;
            if (i - 1 >= 0) {
                while (index >= i) {
                    sum += nums[index] * map.get(i - 1);
                    index--;
                }
            } else {
                sum += nums[i] * values[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
