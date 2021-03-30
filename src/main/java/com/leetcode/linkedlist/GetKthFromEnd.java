package com.leetcode.linkedlist;

import com.bo.ListNode;

/**
 * @author: yhl
 * @DateTime: 2021/3/24 10:12
 * @Description: 链表中倒数第k个节点
 */
public class GetKthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        ListNode kthFromEnd = getKthFromEnd.getKthFromEnd(listNode, 1);
        System.out.println(kthFromEnd);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (k == 0) {
                head = head.next;
            } else {
                k--;
            }
        }
        return head;
    }
}
