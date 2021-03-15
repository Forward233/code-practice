package com.structure.linkedlist;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: yhl
 * @DateTime: 2020/5/18 15:36
 * @Description: [理解单链表的反转(java实现) - 简书](https://www.jianshu.com/p/36ed87e1937a)
 */
public class LinkListReverse {


    public static void main(String[] args) {

        // 1-2-3-4-5
        // 5-4-3-2-1
        LinkNode linkNode1 = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(4);
        LinkNode linkNode5 = new LinkNode(5);
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
//        System.out.println(reverseList(linkNode1));
        /*
        * 注意 不能三个方法同时执行，一个一个执行，
        * 因为在反转链表的方法中会对我们构造的linkNode1链表进行修改
        * */
        System.out.println(recursiveReverse(linkNode1));
//        System.out.println(stackReverse(linkNode1));

    }

    /**
     * 循环遍历
     * @param node
     */
    static LinkNode iterReverse(LinkNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        LinkNode prev = null;
        LinkNode next;
        while (node != null) {
            // 缓存node.next,因为node会被修改
            next = node.next;
            /*
            * 关键：
            * 修改node.next,将next引用指向每次的切割出的新节点
            * 1.第一次执行，node.next = null，即断开了1跟2的连接，此时node = 1
            * 2.第二次执行，pre = 1,node.next = 2->1
            * 3.以此类推
            * */
            node.next = prev;
            // 将node给pre
            prev = node;
            // 利用之前缓存的next给node,继续从node.next循环
            node = next;
        }
        return prev;
    }
    /*

    * */
    static LinkNode recursiveReverse(LinkNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        /*
        * 每次执行递归前的变量的值都会被保留，这是栈的特性
        * */
        LinkNode temp = node.next;
        /*
         * 传入的是node.next
         * 返回的也是node.next引用，递归结束的时候 返回的是5
         * node.next引用和temp指向同一个地址
         * 每次递归结束时，return的值作为下一个newHead的值
         */
        LinkNode newHead = recursiveReverse(node.next);
        /*
        * 此时的递归，是每次递归时新的node
        * temp.next = node.next
        * */
        temp.next = node;
        /*
        * 断开next连接
        * */
        node.next = null;
        return newHead;
    }

    public static LinkNode reverseList(LinkNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点,就是node.next
        LinkNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    /**
     * 栈解法
     * @param node
     */
    static LinkNode stackReverse(LinkNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        /*
        * 创建一个栈，先进后出
        * java已经不推荐使用Stack类，详细原因可Google，所以使用推荐的Deque接口
        * */
        Deque<LinkNode> deque = new ArrayDeque<>();
        // 遍历链表
        while (node != null) {
            deque.push(node);
            node = node.next;
        }
        // 将栈顶元素先设置为链表头
        LinkNode newNode = new LinkNode(deque.pop().value);
        while (!deque.isEmpty()) {
            // 循环从栈顶取出元素给链表的next
            newNode.next = deque.pop();
        }
        return newNode;
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
