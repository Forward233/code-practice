package com.leetcode.linkedlist;

import com.bo.ListNode;

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
        System.out.println(mergeTwoLists3(listNode1, listNode4));
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
            // l2小
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

    // 124 134
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

    // 124 134
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            //  需要不断的向前移动结果链表。next的时候赋值才会正确
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

}
