package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/13 16:48
 * @Description:
 */
public class Approximate {

    public static void main(String[] args){
        Scanner input =  new Scanner(System.in);
        final int round = Math.round(Float.parseFloat(input.next()));
        System.out.println(round);
    }
}
