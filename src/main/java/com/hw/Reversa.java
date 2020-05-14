package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/14 4:56
 * @Description:
 */
public class Reversa {

    public static void main(String[] args) {
        reversa4();
    }

    public static void reversa1() {
        Scanner input = new Scanner(System.in);
        char[] chars = input.next().toCharArray();
        if (chars.length > 1000) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
    }

    public static void reversa2() {
        Scanner input = new Scanner(System.in);
        char[] chars = input.next().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
    }

    public static void reversa3() {
        Scanner input = new Scanner(System.in);
        char[] chars = input.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > 64 && chars[i] < 91 || chars[i] > 96 && chars[i] < 123 || chars[i] == ' ') {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }

    public static void reversa4() {
        Scanner input = new Scanner(System.in);
        String[] strs = input.nextLine().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]).append(" ");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }

}
