package com.hw;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: yhl
 * @DateTime: 2020/5/27 17:30
 * @Description:
 */
public class CountChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            final String s = sc.next();
            Map<Character, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
            }

            final Set<Character> characters = map.keySet();
            StringBuilder sb = new StringBuilder();
            for (Character c : characters) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
