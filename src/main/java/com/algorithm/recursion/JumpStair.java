package com.algorithm.recursion;

/**
 * @author: yhl
 * @DateTime: 2021/1/16 23:17
 * @Description:
 */
public class JumpStair {

    public static void main(String[] args) {

        /*
        * 1: 1
        * 2: 11、2
        * 3：111、12、21、
        * ...
        * */
        System.out.println(jumpStair(8));
    }


    static int jumpStair(int stairNumber) {
        if (stairNumber <= 2) {
            return stairNumber;
        }
        return jumpStair(stairNumber - 1) + jumpStair(stairNumber - 2);
    }

}
