package com.leetcode.linkedlist;

import com.bo.ListNode;

/**
 * @author: yhl
 * @DateTime: 2021/3/29 2:04
 * @Description:
 */
public class ReverseBetween {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode res = reverseBetween.reverseBetween(listNode, 2, 4);
        System.out.println(res);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        head = pre.next;
//        以1->2->3->4->5, m = 2, n=4
//        定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
//        当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
//        前结点仍为2，前驱结点依然是1，重复上一步操作。。。
//        1->4->3->2->5.
        for (int i = left; i < right; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return temp.next;
    }
}
