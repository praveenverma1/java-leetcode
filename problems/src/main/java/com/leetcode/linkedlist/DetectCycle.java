package com.leetcode.linkedlist;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode cycleBegin = null;
        if (head == null)
            return head;
        boolean hasCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            fast = head;
            if (slow == fast) {
                cycleBegin = slow;
                return cycleBegin;
            }
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
                if (slow == fast) {
                    cycleBegin = slow;
                    break;
                }
            }
        }
        return cycleBegin;
    }
}
