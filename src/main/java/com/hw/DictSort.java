package com.hw;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2020/5/14 5:11
 * @Description:
 */
public class DictSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String s = in.next();
            list.add(s);
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        list.forEach(m -> sb.append(m).append("\n"));
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
