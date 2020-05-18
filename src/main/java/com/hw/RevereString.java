package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/13 17:04
 * @Description:
 */
public class RevereString {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str  = input.nextLine();
        StringBuilder sb = new StringBuilder();
        if(str != null && str.length() != 0){
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
