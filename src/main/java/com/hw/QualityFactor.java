package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/12/29 11:54
 * @Description:
 */
public class QualityFactor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num;
        while (scanner.hasNextLong()) {
            num = scanner.nextLong();
            for (int i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                    i--;
                }
            }
            System.out.print(num);
        }

    }
}
