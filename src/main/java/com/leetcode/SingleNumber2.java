package com.leetcode;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2019/11/25 15:59
 * @Description:
 */
public class SingleNumber2 {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        SingleNumber2 singleNumber = new SingleNumber2();
        System.out.println(singleNumber.singleNumber2(arr));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
            if (count == 3) {
                map.remove(num);
            }
        }
        return (int) map.keySet().toArray()[0];
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++, i++) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        if (nums.length %2 != 0) {
            return nums[nums.length - 1];
        }
        return 0;
    }

    public int singleNumber3(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
