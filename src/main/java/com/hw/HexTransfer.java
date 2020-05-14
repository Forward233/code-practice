package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/14 4:31
 * @Description:
 */
public class HexTransfer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        while (input.hasNextLine()) {
//            int num = Integer.parseInt(input.next().substring(2), 16);
//            System.out.println(num);
//        }

        //System.out.println("hello");
        System.out.println(Integer.toBinaryString(365));//十进制转换成二进制
        System.out.println(Integer.toHexString(365));//十进制转换成十六进制
        System.out.println(Integer.toOctalString(365));//十进制转换成8进制
        System.out.println(Integer.toString(10,16));//十进制转换成对应进制数，不适合用于负数，第一个参数为转换数，第二个参数为转换进制

        System.out.println(Integer.parseInt("1010",2));//N进制转换成十进制，返回类型为int,第一个参数为字符串，第二个参数为进制
        System.out.println(Integer.parseInt("1010",8));
        System.out.println(Integer.parseInt("1010",16));


        System.out.println(Integer.valueOf("1010",2));//N进制转换成十进制，返回类型为int,第一个参数为字符串，第二个参数为进制
        System.out.println(Integer.parseInt("1010",8));
        System.out.println(Integer.parseInt("1010",16));

        String hello_world_ = replaceSpace(new StringBuffer("hello world "));
        System.out.println(hello_world_);

        String a = "abcd";
        System.out.println(a.substring(2, a.length()));
        int[] b = {1};
        int length = b.length;
    }

    public static String replaceSpace(StringBuffer str) {
        return  str.toString().replaceAll("\\s+", "%20");
    }
}
