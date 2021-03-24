package com.leetcode.linkedlist;

import com.leetcode.AddTwoNumbers.ListNode;

/**
 * @author: yhl
 * @DateTime: 2021/3/23 17:26
 * @Description:
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(9);
        ListNode res = new DeleteNode().deleteNode(listNode, 5);
        System.out.println(res);
    }


    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) {
            return null;
        }

        if(head.val == val) {
            return head.next;
        }

        //通过temp操作链表
        ListNode temp = head;
        while(temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
