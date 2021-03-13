package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: yhl
 * @DateTime: 2021/3/13 13:06
 * @Description: 最长回文串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
    }


    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (set.contains(c)) {
                count += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return !set.isEmpty() ? count + 1 : count;
    }
}
