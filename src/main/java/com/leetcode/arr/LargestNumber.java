package com.leetcode.arr;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2021/4/12 12:48
 * @Description: 最大数
 */
public class LargestNumber {
    public static void main(String[] args) {

    }

    public String largestNumber(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(Integer::toString)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .reduce("", (s1, s2) -> "0".equals(s1) ? s2 : s1 + s2);
    }
}
