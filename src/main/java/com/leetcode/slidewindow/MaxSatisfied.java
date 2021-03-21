package com.leetcode.slidewindow;

/**
 * @author: yhl
 * @DateTime: 2021/3/22 7:07
 * @Description: 爱生气的书店老板
 */
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        int n = grumpy.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int max = 0;
        int cur = 0;
        for (int i = 0, j = 0; i < n; i++) {
            cur += customers[i];
            // 如果大于窗口长度，减去窗口第一个元素
            if (i - j + 1 > X) {
                cur -= customers[j++];
            }
            max = Math.max(max, cur);
        }
        return ans + max;
    }
}
