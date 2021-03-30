package com.leetcode.linkedlist;

import com.bo.ListNode;

/**
 * @author: yhl
 * @DateTime: 2021/3/31 0:29
 * @Description:
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode kthFromEnd = removeNthFromEnd.removeNthFromEnd(listNode, 2);
        System.out.println(kthFromEnd);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 如果只有一个元素，直接返回null
        if (head.next == null) {
            return null;
        }
        // 快指针
        ListNode fast = head;
        // 最终指向倒数第n个节点
        ListNode temp = head;
        // 最终指向倒数第n个节点的上一个节点
        ListNode pre = null;
        // 找到倒数第n个节点，参考剑指 Offer 22题
        while (fast != null) {
            fast = fast.next;
            if (n == 0) {
                pre = temp;
                temp = temp.next;
            } else {
                n--;
            }
        }

        if (pre != null) {
            // 将倒数第n个节点的上一个节点 指向 倒数第n个节点的下一个节点
            pre.next = temp != null ? temp.next : null;
        } else {
            // 如果pre为null,说明删除的是头结点
            head = head.next;
        }
        return head;
    }
}
