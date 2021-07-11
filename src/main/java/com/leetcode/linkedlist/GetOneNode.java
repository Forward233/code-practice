package com.leetcode.linkedlist;


import com.bo.ListNode;

/**
 * @author: yhl
 * @DateTime: 2021/2/22 20:26
 * @Description:
 */
public class GetOneNode {


    public ListNode getReciprocalNode(ListNode node, int reciprocalNum) {
        ListNode before = node;
        ListNode after = node;
        while (reciprocalNum-- > 0) {
            before = before.next;
        }
        while (before != null) {
            before = before.next;
            after = after.next;
        }
        return after;
    }
}
