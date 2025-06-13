package com.leetcode.linkedlist;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        ListNode test = obj.deleteDuplicates(head);
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode temp = dummy;
        ListNode current = head;
        while (current != null) {
            if (temp.val < current.val) {
                temp.next = current;
                temp = current;
                current = current.next;
            } else if (temp.val == current.val) {
                temp.next = null;
                current = current.next;
            }
        }
        return dummy.next;
    }

}
