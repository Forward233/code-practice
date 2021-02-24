package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: yhl
 * @DateTime: 2021/2/23 17:31
 * @Description: 每日温度
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] arr = {73, 74, 75, 73, 69, 72, 76, 73};
        int[] ints = dailyTemperatures.dailyTemperaturesWithStack(arr);
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

    /**
     * 维护单调递增栈，从栈顶--->栈底
     * 当循环过程中，有元素大于栈顶元素，则遍历栈中的元素，计算结果
     * 重点，保证栈顶保存的是最小元素的索引，单调递增
     *
     * @param T
     * @return
     */
    public int[] dailyTemperaturesWithStack(int[] T) {
        int[] ans = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] >T[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
