package com.structure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: yhl
 * @DateTime: 2021/1/5 14:32
 * @Description:
 */
public class StackTest {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.push(3);
        System.out.println(deque);
        Integer peek = deque.peek();
        System.out.println(peek);
        System.out.println(deque);
        Integer pop = deque.pop();
        System.out.println(pop);
        System.out.println(deque);
    }
}
