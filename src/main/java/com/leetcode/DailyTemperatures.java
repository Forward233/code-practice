package com.leetcode;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2021/2/23 17:31
 * @Description:
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures.dailyTemperatures(arr);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * brute force
     * @param T
     * @retur
     */
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            ans[i] = 0;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}
