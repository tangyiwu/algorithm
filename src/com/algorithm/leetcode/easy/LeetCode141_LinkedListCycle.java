package com.algorithm.leetcode.easy;

import com.algorithm.model.ListNode;

public class LeetCode141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
            slow = slow.next;
        }
        return false;
    }
}
