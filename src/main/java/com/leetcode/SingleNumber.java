package com.leetcode;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2019/11/25 15:59
 * @Description:
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2, 4, 2};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber3(arr));
    }

    public int singleNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(String.valueOf(num))) {
                list.remove(String.valueOf(num));
            } else {
                list.add(String.valueOf(num));
            }
        }
        return Integer.parseInt(list.get(0));
    }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public int singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return (int) set.toArray()[0];
    }
}
