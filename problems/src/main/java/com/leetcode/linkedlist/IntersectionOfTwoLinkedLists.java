package com.leetcode.linkedlist;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode c1 = headA;
        ListNode c2 = headB;
        int i = 0;
        int j = 0;
        ListNode tailA = null;
        ListNode tailB = null;
        while (c1 != null) {
            i++;
            if (c1.next == null)
                tailA = c1;
            c1 = c1.next;
        }
        while (c2 != null) {
            j++;
            if (c2.next == null)
                tailB = c2;
            c2 = c2.next;
        }
        if (tailA != tailB)
            return null;
        c1 = headA;
        c2 = headB;
        while (i != j) {
            if (i > j) {
                c1 = c1.next;
                i--;
            } else {
                c2 = c2.next;
                j--;
            }
        }
        while (c1 != c2) {
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1;
    }
}
