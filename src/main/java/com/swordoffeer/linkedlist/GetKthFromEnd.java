package com.swordoffeer.linkedlist;

import com.bo.ListNode;

/**
 * @author: yhl
 * @DateTime: 2021/3/24 10:12
 * @Description: 链表中倒数第k个节点
 */
public class GetKthFromEnd {

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
