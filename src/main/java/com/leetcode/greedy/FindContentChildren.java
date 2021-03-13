package com.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2021/3/13 15:06
 * @Description: 分发饼干
 */
public class FindContentChildren {

    public static void main(String[] args) {
        //g = [1,2], s = [1,2,3]
        // 胃口
        int[] g = {1, 1};
        // 尺寸
        int[] s = {1, 2, 3};
        System.out.println(new FindContentChildren().findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; count < g.length && i < s.length; i++) {
            if (g[count] <= s[i]) {
                count++;
            }
        }
        return count;
    }
}
