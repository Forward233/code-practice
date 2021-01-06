package com.sort;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: yhl
 * @DateTime: 2020/1/15 16:06
 * @Description:
 */
public class RadixSort {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
