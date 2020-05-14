package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/13 21:50
 * @Description:
 */
public class PrimeFactor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        int factor = 2;
        StringBuilder sb = new StringBuilder();
        while (factor <= num) {
            if (num % factor == 0) {
                num = num / factor;
                sb.append(factor).append(" ");
            } else {
                factor++;
            }
        }
        System.out.println(sb.toString());
    }
}
