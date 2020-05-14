package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/14 21:39
 * @Description:
 */
public class Location {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String location = in.nextLine();
            String[] locations = location.split(";");
            int a = 0;
            int b = 0;

            for (String l : locations) {
                try {
                    int num = Integer.parseInt(l.substring(1));
                    if (l.charAt(0) == 'A') {
                        a -= num;
                    }
                    if (l.charAt(0) == 'D') {
                        a += num;
                    }
                    if (l.charAt(0) == 'W') {
                        b += num;
                    }
                    if (l.charAt(0) == 'S') {
                        b -= num;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println(a + "," + b);
        }
    }
}
