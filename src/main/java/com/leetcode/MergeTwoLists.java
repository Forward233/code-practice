package com.leetcode;

import com.alibaba.fastjson.JSON;

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

        ListNode listNode = new MergeTwoLists().mergeTwoLists(listNode1, listNode4);
        System.out.println(JSON.toJSONString(listNode));
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        ListNode r = null;
        while (l1Node != null) {
            int l1Val = l1Node.val;
            while (l2Node != null) {
                if (l1Val >= l2Node.val) {
                    // 断开
                    l2Node.next = new ListNode(l1Node.val, l2Node.next);
                    r = l2Node;
                    l2Node = l1Node.next;
                    break;
                }
            }
            l1Node = l1Node.next;
        }

        return r;
    }

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
