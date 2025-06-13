package com.leetcode.linkedlist;

public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(0);
        ListNode sixth = new ListNode(6);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;
        SortList sortList = new SortList();
        ListNode current = sortList.sortList(head);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode sortedA = sortList(head);
        ListNode sorttedB = sortList(right);
        return merge(sortedA, sorttedB);
    }

    /*
     * We have altered the findMiddle implementation
     * so that we are able ti break the list properly
     * and not return the second middle for even length lists
     */
    private ListNode findMiddle(ListNode current) {
        ListNode slow = current;
        ListNode fast = current;
        ListNode prev = current;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private ListNode merge(ListNode currentA, ListNode currentB) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (currentA != null && currentB != null) {
            if (currentA.val <= currentB.val) {
                temp.next = currentA;
                temp = currentA;
                currentA = currentA.next;
            } else {
                temp.next = currentB;
                temp = currentB;
                currentB = currentB.next;
            }
        }
        if (currentA != null)
            temp.next = currentA;
        if (currentB != null)
            temp.next = currentB;
        return dummy.next;
    }
}
