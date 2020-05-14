package com.hw;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: yhl
 * @DateTime: 2020/5/13 21:06
 * @Description:
 */
public class MergeIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int num = Integer.parseInt(in.nextLine());
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            final String line = in.nextLine();
            String[] str = line.split(" ");
            int key = Integer.parseInt(str[0]);
            int value = Integer.parseInt(str[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((k,v) -> {
            sb.append(k).append(" ").append(v).append("\n");
        });
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
