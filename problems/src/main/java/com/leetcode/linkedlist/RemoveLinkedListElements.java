package com.leetcode.linkedlist;

public class RemoveLinkedListElements {
    /*
     * Just keep a dummy node and iterate though the List
     * and the change the temp references
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode temp = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.val != val) {
                temp.next = current;
                temp = current;
                current = current.next;
            } else if (current.val == val) {
                temp.next = null; // temp.next will be updated again based on the if condition above
                current = current.next;
            }
        }
        return dummy.next;
    }
}
