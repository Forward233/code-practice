package com.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: yhl
 * @DateTime: 2021/4/1 2:34
 * @Description:
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for(int num : pushed ){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
