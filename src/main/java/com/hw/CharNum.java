package com.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/13 20:38
 * @Description:
 */
public class CharNum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] chars = input.nextLine().toCharArray();
        System.out.println(chars.length);
        int count = 0;
        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            if ((int) c  > 0 && (int) c < 127 ) {
                if (!list.contains(c)) {
                    count++;
                }
                list.add(c);
            }
        }
        System.out.println(count);
    }
}
