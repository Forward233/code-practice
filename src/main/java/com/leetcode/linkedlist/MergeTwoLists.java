package com.leetcode.linkedlist;

import lombok.Data;

/**
 * @author: yhl
 * @DateTime: 2021/1/5 15:06
 * @Description:
 */
public class MergeTwoLists {


    //Input: l1 = [1,2,4], l2 = [1,3,4]

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode4.next = listNode5;
        listNode5.next = listNode6;
//        System.out.println(mergeTwoLists(listNode1, listNode4));
        System.out.println(recursionMergeList(listNode1, listNode4));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 124 134
        ListNode pre = new ListNode(-1);
        ListNode end = pre;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                end.next = l2;
                end = l2;
                l2 = l2.next;
            } else {
                end.next = l1;
                end = l1;
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            end.next = l2;
        } else {
            end.next = l1;
        }
        return pre.next;
    }

    public static ListNode recursionMergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = recursionMergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = recursionMergeList(l1, l2.next);
            return l2;
        }
    }


    @Data
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
