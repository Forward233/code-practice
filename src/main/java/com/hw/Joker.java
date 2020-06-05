package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/27 7:58
 * @Description:
 */
public class Joker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String[] s1s = s1.split(" ");
            System.out.println(Integer.parseInt(s1s[0]) + Integer.parseInt(s1s[1]));
            String[] s2s = s2.split(" ");
            System.out.println(Integer.parseInt(s2s[0]) + Integer.parseInt(s2s[1]));
        }
    }
}
