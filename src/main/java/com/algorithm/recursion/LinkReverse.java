package com.algorithm.recursion;

import lombok.Data;

/**
 * @author: yhl
 * @DateTime: 2020/5/18 15:36
 * @Description: [理解单链表的反转(java实现) - 简书](https://www.jianshu.com/p/36ed87e1937a)
 */
public class LinkReverse {


    public static void main(String[] args) {

        LinkNode linkNode1 = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(4);
        LinkNode linkNode5 = new LinkNode(5);
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        reverse(linkNode1);
    }

    static void reverse(LinkNode node) {
        if (node == null || node.next == null) {
            return;
        }
        LinkNode pre = null;
        LinkNode next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        while (pre.next != null) {
            System.out.println(pre.value);
            pre = pre.next;
        }
        System.out.println(pre.value);

    }


    @Data
    static class LinkNode {
        private final Object value;
        private LinkNode next;

        public LinkNode(Object value) {
            this.value = value;
        }
    }
}
