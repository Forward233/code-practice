package com.test;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2021/4/5 14:19
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        String checkStr = strs[0];
        String sensitiveWords = strs[1];
        StringBuilder xing = new StringBuilder();
        for (int i = 0; i < sensitiveWords.length(); i++) {
            xing.append("*");
        }
        String newStr = checkStr.replace(sensitiveWords, xing.toString());
        System.out.println(newStr);
    }
}
