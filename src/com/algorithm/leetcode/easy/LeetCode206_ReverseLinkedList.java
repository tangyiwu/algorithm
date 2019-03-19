package com.algorithm.leetcode.easy;

import com.algorithm.model.ListNode;

public class LeetCode206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = head;
        while (next != null) {
            ListNode postNext = next.next;
            next.next = pre;
            pre = next;
            next = postNext;
        }
        return pre;
    }
}
