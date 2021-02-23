package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yhl
 * @DateTime: 2021/1/5 12:59
 * @Description:
 */
public class ValidParentheses {

    public static void main(String[] args) {
        // [({})]
        boolean valid = new ValidParentheses().isValidWithMap("[({})]");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidWithMap(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Character> temp = new HashMap<>();
        temp.put('{', '}');
        temp.put('[', ']');
        temp.put('(', ')');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() || temp.get(stack.pop()) != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


}
