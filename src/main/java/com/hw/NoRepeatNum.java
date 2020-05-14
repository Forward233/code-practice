package com.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/13 20:51
 * @Description:
 */
public class NoRepeatNum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = input.next();
        final char[] chars = num.toCharArray();
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!list.contains(chars[i])) {
                sb.append(chars[i]);
            }
            list.add(chars[i]);
        }
        System.out.println(sb.toString());
    }

}
