package com.leetcode;

/**
 * @author: yhl
 * @DateTime: 2021/1/4 22:06
 * @Description:  回文 双指针
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        boolean palindrome = new ValidPalindrome().isPalindrome("babad");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    public static boolean isLetter(char c){
        return  c >= 'a' && c<= 'z' || c >= 'A' && c<= 'Z' ;
    }
}
