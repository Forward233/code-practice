package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/27 7:36
 * @Description:
 */
public class MaxContinuous {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int count = 0, MaxCount = 0;
            while (num != 0) {
                if ((num & 1) > 0) {
                    ++count;
                    MaxCount = Math.max(count, MaxCount);
                } else {
                    count = 0;
                }
                num = num >> 1;
            }
            System.out.println(MaxCount);
        }

    }
}
