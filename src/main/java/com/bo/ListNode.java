package com.bo;

import lombok.Data;

/**
 * @author: yhl
 * @DateTime: 2021/3/23 5:46
 * @Description:
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
