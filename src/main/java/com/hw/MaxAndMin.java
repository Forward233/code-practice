package com.hw;

import java.util.Scanner;

/**
 * @author: yhl
 * @DateTime: 2020/5/13 17:22
 * @Description: 最大公约数和最小公倍数
 * 第一个最大公约数使用的2300年前被发明的欧几里得算法求得，大致原理为:
 *
 * 如果有两个非负整数p、q，若q==0,则最大公约数为p；否则,p和q的最大公约数就是p除以q所得的余数和q的最大公约数。
 *
 * 第二个最小公倍数更简单
 * 如果有两个非负整数p、q，若q==0,则最大公约数为p；否则,p和q的最大公约数就是p除以q所得的余数和q的最大公约数。
 */
public class MaxAndMin {

    public static void main(String[] args) {
        Scanner pIn = new Scanner(System.in);
        int p = Integer.parseInt(pIn.next());
        int q = Integer.parseInt(pIn.next());
        final int gcd = gcd(p, q);
        System.out.println(gcd);
    }


    //最大公约数(Greatest Common Divisor)
    public static int gcd(int p,int q){
        if(q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    //最小公倍数(Least Common Multiple)　
    public static int lcm(int p,int q){
        int pq = p * q;
        return pq / gcd(p,q);
    }
}
