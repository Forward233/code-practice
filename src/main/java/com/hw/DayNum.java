package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/16 7:27
 * @Description:
 */
public class DayNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (i < 3) {
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            if (month < 3) {
                System.out.println(31 + day);
            } else if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                // 3 5 7
                //   4 6
                // 8 10 12
                //    9 11
                int a = 31 + 28;
                int b = 0;
                if (3 <= month && month < 8) {
                    if ((month - 3) % 2 == 0) {
                        b = (30 + 31) * (month - 3) / 2 + day + a;
                    } else {
                        b = 30 * ((month - 3) / 2 - 1) + 31 * ((month - 3) / 2)+ day + a;
                    }
                }
                System.out.println(b);
            }
            i++;
        }
    }
}
