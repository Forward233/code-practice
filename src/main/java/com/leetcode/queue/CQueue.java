package com.leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: yhl
 * @DateTime: 2021/3/6 14:00
 * @Description: 用两个栈实现队列
 */
public class CQueue {

    // 先进后出
    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;

    // 先进先出
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
