package com.leetcode.linkedlist;

public class HasCycle {
    /*
     * Very simple implementation
     * if there is no cycle the fast pointer will always be ahead of the slow
     * pointer
     * hence we put out null check based on the fast pointer and
     * move fast by two steps and slow by one step
     * In case of a cycle they will meet
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
