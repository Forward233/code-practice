package com.leetcode.linkedlist;

import com.bo.ListNode;

/**
 * @author: yhl
 * @DateTime: 2021/3/31 6:50
 * @Description:
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //查找接入点
            if(fast == slow){
                while(head != fast){
                    fast = fast.next;
                    head = head.next;
                }
                return fast;
            }
        }
        return null;
    }
}
