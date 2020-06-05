package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/28 19:16
 * @Description:
 */
public class CountAndAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count1 = 0;
        int count2 = 0;
        float sum = 0;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n < 0) {
                count1++;
            } else {
                count2++;
                sum += n;
            }
        }
        System.out.println(count1);
        System.out.printf("%.1f", sum / count2);

    }
}
