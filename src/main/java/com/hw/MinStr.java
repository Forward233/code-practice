package com.hw;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2020/5/15 13:15
 * @Description:
 */
public class MinStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Map<Character, Integer> map = new IdentityHashMap<>();
            char[] ch = in.nextLine().toCharArray();
            for (char c : ch) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            final Collection<Integer> values = map.values();
            final Integer min = Collections.min(values);
            StringBuilder sb = new StringBuilder();
            for (char c : ch) {
                if (!map.get(c).equals(min)) {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
