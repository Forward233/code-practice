package com.hw;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yhl
 * @DateTime: 2021/4/2 13:39
 * @Description: 无重复字符的最长子串
 */
public class MaxLength {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 3};
        MaxLength maxLength = new MaxLength();
        System.out.println(maxLength.maxLength(arr));
    }

    public int maxLength (int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                left = Math.max(left, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            // 计算位置
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
