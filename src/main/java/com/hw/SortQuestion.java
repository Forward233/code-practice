package com.hw;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: yhl
 * @DateTime: 2020/5/14 17:14
 * @Description:
 */
public class SortQuestion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Set<Integer> set = new TreeSet<>();
            int num = in.nextInt();
            while (num > 0) {
                set.add(in.nextInt());
                --num;
            }
            set.forEach(s -> System.out.println(s.intValue()));
        }
    }
}
