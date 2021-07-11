package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2021/4/2 10:49
 * @Description:
 */
public class AddXing {
//    5O6t6FFtIlMVDn7rTaZki4Pl42Xx6n
//    2211KpU0o7nZbj
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            StringBuilder sb = new StringBuilder();
            char[] c = str.toCharArray();
            int i = 0;
            while (i < c.length) {
                if (Character.isDigit(c[i])) {
                    sb.append("*");
                    sb.append(c[i]);
                    while (++i < c.length && Character.isDigit(c[i])) {
                        sb.append(c[i]);
                    }
                    sb.append("*");
                } else {
                    sb.append(c[i]);
                    i++;
                }
            }
            System.out.println(sb.toString());
        }
    }
}