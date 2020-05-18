package com.hw;

import java.util.Scanner;

public class JumpFloorII {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num != 0) {
                System.out.println(num / 2);
            }
        }
    }
}


