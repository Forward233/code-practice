package com.leetcode.string;

/**
 * @author: yhl
 * @DateTime: 2021/3/13 17:13
 * @Description:
 */
public class LongestSubPalindrome {

    public static void main(String[] args) {
        LongestSubPalindrome longestSubPalindrome = new LongestSubPalindrome();
        System.out.println(longestSubPalindrome.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
