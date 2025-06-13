package com.leetcode.linkedlist;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {

    }

    /*
     * Take a dummy node and then point temp to that dummy node initially
     * then compare the nodes in two sorted lists
     * and move the temp node
     * in the end return dummy.next
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode c1 = list1;
        ListNode c2 = list2;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                temp.next = c1;
                temp = c1;
                c1 = c1.next;
            } else {
                temp.next = c2;
                temp = c2;
                c2 = c2.next;
            }
        }
        if (c1 != null)
            temp.next = c1;
        if (c2 != null)
            temp.next = c2;
        return dummy.next;
    }
}
