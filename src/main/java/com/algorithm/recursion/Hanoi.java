package com.algorithm.recursion;

/**
 * @author: yhl
 * @DateTime: 2019/11/20 10:46
 * @Description: 汉诺塔
 *
 * reference ：[java基础实现经典汉诺塔，超级简单 - renlianggee - CSDN博客](https://blog.csdn.net/renlianggee/article/details/89945824)
 */

public class Hanoi {

    /**
     * 一共走了多少步
     */
    private static int times;

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(2, 'A', 'B', 'C');
    }

    /*
        (3)  n == 3
    　  第1次 1号盘 A—->C
    　　第2次 2号盘 A—->B
    　　第3次 1号盘 C—->B
    　　第4次 3号盘 A—->C
    　　第5次 1号盘 B—->A
    　　第6次 2号盘 B—->C
    　　第7次 1号盘 A—->C
        sum = 7 次
     */

    void hanoi(int n, char a, char b, char c) {
        // 圆盘只有一个时，只需将其从A塔移到C塔
        if (n == 1) {
            //将编b号为1的圆盘从A移到C
            move(1, a, c);
        } else {
            //递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            hanoi(n - 1, a, c, b);
            //把A塔上编号为n的圆盘移到C上
            move(n, a, c);
            //递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
            hanoi(n - 1, b, a, c);
        }
    }

    /**
     * 盘子移动
     * @param disk
     * @param M
     * @param N
     */
    public static void move(int disk, char M, char N ){
        System.out.println("第"+(++times)+"次移动, 盘子"+ disk+ ": "+M+"------->"+N);
    }

}
