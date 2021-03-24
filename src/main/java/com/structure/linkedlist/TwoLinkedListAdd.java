package com.structure.linkedlist;


import com.bo.ListNode;

/**
 * @author: yhl
 * @DateTime: 2021/2/21 12:59
 * @Description:
 */
public class TwoLinkedListAdd {

    public static void main(String[] args) {
//        [9,9,9,9,9,9,9]
//        [9,9,9,9]
//        [8,9,9,9,0,0,0,1]
        final TwoLinkedListAdd twoLinkedListAdd = new TwoLinkedListAdd();
        ListNode a = new ListNode(9);
        a.next = new ListNode(9);
        a.next.next = new ListNode(9);
        a.next.next.next = new ListNode(9);
        a.next.next.next.next = new ListNode(9);
        a.next.next.next.next.next = new ListNode(9);
        a.next.next.next.next.next.next = new ListNode(9);

        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
        b.next.next = new ListNode(9);
        b.next.next.next = new ListNode(9);
        final ListNode listNode = twoLinkedListAdd.addTwoNumbers(a, b);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return  l1==null ? l1 : l2;
        }
        ListNode result = null,tail = null;
        int carry = 0;
        while(l1 != null  || l2 != null){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 +val2 + carry;
            if(result == null){
                result = tail = new ListNode(sum %10 );
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum /10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;;
            }
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return result;
    }
}
