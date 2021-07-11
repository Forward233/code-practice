package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2021/4/4 0:11
 * @Description:
 */
public class PrimeNumberPartner {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int n = 0;
            int m = 0;
            for (int i = 0; i < num; i++) {
                int nums = sc.nextInt();
                if (nums % 2 == 0) {
                    n++;
                } else {
                    m++;
                }
            }
            System.out.println(Math.min(n, m));
        }

    }
}
