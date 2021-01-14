package com.structure.list;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

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
        LinkNode linkNode = recursiveReverse(linkNode1);
//        System.out.println(linkNode);
//        stackReverse(linkNode1);
//        iterReverse(linkNode1);
    }

    // 遍历
    static void iterReverse(LinkNode node) {
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
        while (pre!= null) {
            System.out.println(pre.value);
            pre = pre.next;
        }
    }

    // 递归

    // 1-2-3-4
    // 4-3-2-1
    static LinkNode recursiveReverse(LinkNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        LinkNode temp = node.next;
        LinkNode newHead = recursiveReverse(node.next);
        temp.next = node;
        node.next = null;
        return newHead;
    }

    static void stackReverse(LinkNode node) {
        if (node == null || node.next == null) {
            return;
        }
        Deque<LinkNode> deque = new ArrayDeque<>();
        while (node != null) {
            deque.push(node);
            node = node.next;
        }
        LinkNode newNode = new LinkNode(deque.pop().value);
        while (!deque.isEmpty()) {
            newNode.next = deque.pop();
        }
        System.out.println(newNode);
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
