package com.leetcode.linkedlist;

public class OddEvenList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;
        OddEvenList oddEvenList = new OddEvenList();
        ListNode current = oddEvenList.oddEvenList(head);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode dummy1 = new ListNode(-1);
        ListNode t1 = dummy1;

        ListNode dummy2 = new ListNode(-1);
        ListNode t2 = dummy2;

        ListNode current = head;

        while (current != null) {
            t1.next = current;
            t1 = current;
            if (current.next != null) {
                t2.next = current.next;
                t2 = current.next;
            }
            if (current.next != null) {
                current = current.next.next;
            } else
                break;
        }
        t2.next = null;
        t1.next = dummy2.next;
        return dummy1.next;
    }
}
