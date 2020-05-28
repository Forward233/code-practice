package com.hw;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2020/5/27 16:57
 * @Description:
 */
public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums; i++) {
                list.add(sc.nextInt());
            }

            int sort = sc.nextInt();
            if (sort == 0) {
                Collections.sort(list);
            } else {
                list.sort((o1, o2) -> o2 - o1);
            }
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer).append(" ");
            }
            System.out.println(sb.toString());
        }

    }
}
