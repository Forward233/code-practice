package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/28 11:38
 * @Description:
 */
public class RedRaiment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            int[] a = new int[nums];
            for (int i = 0; i < nums; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(getMaxStep(a));
        }
    }

    //6
    //2 5 1 5 4 5
    public static int getMaxStep(int[] a) {
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int value : dp) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
