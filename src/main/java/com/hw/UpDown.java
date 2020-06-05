package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/28 7:46
 * @Description:
 */
public class UpDown {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int singNums = sc.nextInt();
            String opt = sc.next();
            String list = null;
            int nowSing = 1;
            if (opt.length() < 5) {
                list = "1 2 3 4";
                for (int i = 0; i < opt.length(); i++) {
                    if (i%3== 1 && opt.charAt(i) == 'D') {

                    }
                }
            }

        }
    }
}
