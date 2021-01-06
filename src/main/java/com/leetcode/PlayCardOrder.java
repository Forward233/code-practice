package com.leetcode;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2021/1/5 9:50
 * @Description:
 * 第一步， 魔术师从牌顶拿出一张牌， 放到桌子上。
 * 第二步， 魔术师从牌顶再拿一张牌， 放在手上牌的底部。
 * 第三步， 重复第一/二步的操作， 直到魔术师手中所有的牌都放到了桌子上。
 */
public class PlayCardOrder {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(arr[0]);
        queue.add(arr[1]);
//        第一步，从手中的牌底拿出一张牌，放到手中牌的牌顶。
//        第二步，从桌子上牌顶拿出一张牌，放到手中牌的牌顶。
//        第三步， 重复第一/二步的操作， 直到桌子上所有的牌都放到了手中。
        for (int i = 2; i < arr.length; i++) {
            queue.add(queue.poll());
            queue.add(arr[i]);
        }
        System.out.println(queue);

        int index = queue.size() - 1;
        int[] newArr = new int[queue.size()];
        while (!queue.isEmpty()) {
            newArr[index] = queue.poll();
            index--;
        }

        System.out.println(Arrays.toString(newArr));
    }
}
