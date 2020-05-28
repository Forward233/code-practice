package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/28 16:55
 * @Description:
 */
public class Completion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            for(int i=0; i<n; i++) {
                String temp = sc.next();
                while(temp.length()%8!=0) {
                    temp += "0";
                }
                for(int j=0; j<temp.length(); j+=8) {
                    System.out.println(temp.substring(j, j+8));
                }
            }
        }
    }
}
