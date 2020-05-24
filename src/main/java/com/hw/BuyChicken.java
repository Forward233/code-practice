package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/16 7:05
 * @Description:
 */
public class BuyChicken {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //5 3 1/3
        while (in.hasNext()) {
            in.next();
            for (int a = 0; a < 20; a++) {
                for (int b = 33; b > 0; b--) {
                    int c = 100 - a - b;
                    if ((a + b + c) == 100 && 5 * a + 3 * b + c / 3 == 100 && c%3 == 0) {
                        System.out.println(a + " " + b + " " + c);
                    }
                }
            }

        }

    }
}
