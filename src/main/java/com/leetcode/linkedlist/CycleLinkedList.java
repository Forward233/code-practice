package com.leetcode.linkedlist;


import com.bo.ListNode;

/**
 * @author: yhl
 * @DateTime: 2019/11/26 18:09
 * @Description: 环形链表
 */
public class CycleLinkedList {

    public static void main(String[] args) {

    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public boolean hasCycleWithDoublePoint(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        // 如果没有环，快指针先走到链表尾部，如果有环，则一直循环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleWithSign(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        // 如果没有环，快指针先走到链表尾部，如果有环，则一直循环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
