package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: yhl
 * @DateTime: 2019/11/26 13:37
 * @Description:
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {3,0,1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber3(arr));
    }

    /**
     * [3,0,1]
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }

    /**
     * XOR 相同的两个数做^运算，为0
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }
}
