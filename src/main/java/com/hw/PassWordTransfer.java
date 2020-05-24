package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/16 7:05
 * @Description:
 */
public class PassWordTransfer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            char[] pwChars = in.next().toCharArray();
            for (int i = 0; i < pwChars.length; i++) {
                int cNum = pwChars[i];
                if (cNum > 96 && cNum < 123) {
                    sb.append(getNum(new String(new char[]{pwChars[i]})));
                } else if (cNum > 64 && cNum < 91) {
                    char newCh;
                    if (pwChars[i] == 'Z') {
                        newCh = 'a';
                    } else {
                        int nNum = cNum + 33;
                        newCh = (char) nNum;
                    }
                    sb.append(newCh);
                } else {
                    sb.append(pwChars[i]);
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static int getNum(String c) {
        String s2 = "abc";
        String s3 = "def";
        String s4 = "ghi";
        String s5 = "jkl";
        String s6 = "mno";
        String s7 = "pqrs";
        String s8 = "tuv";
        String s9 = "wxyz";
        if (s2.contains(c)) {
            return 2;
        }
        if (s3.contains(c)) {
            return 3;
        }
        if (s4.contains(c)) {
            return 4;
        }
        if (s5.contains(c)) {
            return 5;
        }
        if (s6.contains(c)) {
            return 6;
        }
        if (s7.contains(c)) {
            return 7;
        }
        if (s8.contains(c)) {
            return 8;
        }
        if (s9.contains(c)) {
            return 9;
        }
        return 0;
    }

}
