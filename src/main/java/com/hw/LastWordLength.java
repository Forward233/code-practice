package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2019/12/13 15:53
 * @Description:
 */
public class LastWordLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().toLowerCase();
        char c = scanner.next().toLowerCase().charAt(0);
        final char[] chars = str.toCharArray();
        int count = 0;
        for (char ch : chars) {
            if(ch == c){
                count++;
            }
        }
        System.out.println(count);
    }
}
