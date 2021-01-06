package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: yhl
 * @DateTime: 2021/1/5 12:59
 * @Description:
 */
public class ValidParentheses {

    public static void main(String[] args) {
        new ValidParentheses().isValid("([)]");
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : chars) {
            if (c == '{') {
                deque.push('}');
            } else if (c == '[') {
                deque.push(']');
            } else if (c == '(') {
                deque.push(')');
            } else if (deque.isEmpty() || c != deque.pop()) {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
