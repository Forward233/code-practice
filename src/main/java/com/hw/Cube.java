package com.hw;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/13 17:15
 * @Description: 开立方  //牛顿迭代 f(x) = x^3-num, f'(x)=3*x^2;x=x-f(x)/f'(x);
 */
public class Cube {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        if (num == 0) {
            System.out.println(num);
        }
        double num1, num2;
        num1 = num;
        num2 = (2 * num1 / 3) + (num / (num1 * num1 * 3));// 利用牛顿迭代法求解
        while (Math.abs(num2 - num1) > 0.000001) {
            num1 = num2;
            num2 = (2 * num1 / 3) + (num / (num1 * num1 * 3));
        }
        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println(Double.parseDouble(df.format(num2)));
    }
}
