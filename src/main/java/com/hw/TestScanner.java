package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2019/12/14 17:30
 * @Description:
 */
public class TestScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
