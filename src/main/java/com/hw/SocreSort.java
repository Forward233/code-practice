package com.hw;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2020/5/31 9:07
 * @Description:
 */
public class SocreSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            int sort = sc.nextInt();
            Map<String, Integer> map = new IdentityHashMap<>();
            List<Integer> scores = new ArrayList<>();
            for (int i = 0; i < nums; i++) {
                String name = sc.next();
                int score = sc.nextInt();
                scores.add(score);
                map.put(name, score);
            }
            Collections.sort(scores);
            if (sort == 0) {
                Collections.reverse(scores);
            }

            int pre = -1;
            for (int score : scores) {
                if (pre == score)
                    continue;
                for (String key : map.keySet())
                    if (map.get(key).equals(score)){
                        System.out.println(key + " " + score);
                    }
                pre = score;
            }
        }
    }
}
