package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/14 5:54
 * @Description:
 */
public class OneNums {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String binaryNum = Integer.toBinaryString(num);
        char[] chars = binaryNum.toCharArray();
        int count = 0;
        for (char a : chars) {
            if (a == '1') {
                count++;
            }
        }
        // 以为运算
//        while(n>0){
//            if((n&1)>0){
//                count++;
//            }
//            n=n>>1;
//        }
        System.out.println(count);
    }
}
