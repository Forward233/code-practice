package com.algorithm.interview;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2021/3/7 12:00
 * @Description:  洗牌
 */
public class Shuffle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] nums2 = new int[n];
        int s1 = 0, s2;
        if (n % 2 == 0) {
            s2 = n / 2;
        } else {
            s2 = n / 2 + 1;
        }

        // 开始洗牌
    }


}
