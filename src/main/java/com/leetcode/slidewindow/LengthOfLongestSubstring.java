package com.leetcode.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yhl
 * @DateTime: 2021/3/7 1:14
 * @Description:无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        // abcabcdbb  "pwwkew" "abba"
        int res = lengthOfLongestSubstring.lengthOfLongestSubstring("abba");
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
