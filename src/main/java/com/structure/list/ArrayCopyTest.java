package com.structure.list;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2020/4/6 5:45
 * @Description:
 *
 * 数组是连续内存的，数组名就是数组存放的首地址，根据数据类型以及下标求出偏移量就可以访问到对应位置的数据。
 * 链表不是连续的
 */
public class ArrayCopyTest {

    public static void main(String[] args) {
        Object[] a = {1, 2, 3, 4, 5};
        int length = a.length;
        int index = 2;
        // -1 因为索引从0开始，少减去一个
        int numMoved = length - index - 1;
        System.arraycopy(a, index + 1, a, index, numMoved);
        a[--length] = null;
        for (Object i : a) {
            System.out.println(i);
        }

        final Object[] objects = Arrays.copyOf(a, 1);
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
