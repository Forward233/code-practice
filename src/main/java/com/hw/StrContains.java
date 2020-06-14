package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/26 19:31
 * @Description:
 */
public class StrContains {
    public static void main(String[] args) {
//        final String[] as = "aaaa125aaa12345689".split("a");
//        for (String arg : as) {
//            System.out.println(arg);
//        }
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (c < '0' || c > '9') {
                    sb.append("a");
                } else {
                    sb.append(c);
                }
            }
            int count = 0;
            StringBuilder temp = new StringBuilder();
            final String[] strs = sb.toString().split("a");
            for (String str : strs) {
                if (str.length() > 0) {
                    if (str.length() > count) {
                        count = str.length();
                    }
                }
            }
            for (String str : strs) {
                if (str.length() == count) {
                    temp.append(str);
                }
            }

            System.out.println(temp.toString() + "," + count);
        }
    }
}
