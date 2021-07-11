package com.leetcode.math;

/**
 * @author: yhl
 * @DateTime: 2021/3/29 15:13
 * @Description:回文数
 *
 * 从尾部开始计算，看是否能计算出与从头部开始的相同的值，如123321  计算的过程，cur(123) == num(123)的时候，满足条件
 */
public class IsPalindrome {

    public IsPalindrome() {
        {
            System.out.println("haha");
        }
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(21120));
    }

    public boolean isPalindrome(int x) {
        // 如果小于0，或者末位为0且不等于0，直接返回false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int cur = 0;
        int num = x;
        while(num != 0) {
            // 从尾部开始计算
            cur = cur * 10 + num % 10;
            // 去掉原数已经计算过的位
            num /= 10;
            // 如果两个值相同，直接返回
            if (num == cur) {
                return true;
            }
        }
        return cur == x;
    }
}
