package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Author: yhl
 * DateTime: 2019/11/4 11:29
 * Description: write some description
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        final TwoSum twoSum = new TwoSum();
        final int[] ints = twoSum.twoSum3(arr, 6);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * brute force
     * @param nums
     * @param target
     * @return
     */
    public  int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public  int[] twoSum2(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value) && map.get(value) != i) {
                return new int[]{i,map.get(value)};
            }
        }
        return null;
    }

    public  int[] twoSum3(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int value = target - nums[i];
            if(map.containsKey(value)){
                return new int[]{map.get(value), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
