package com.algorithm.leetcode.medium;

import com.algorithm.model.ListNode;

public class LeetCode2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int m = 0;
        int digitSum = 0;
        int curValue = 0;
        while (l1 != null || l2 != null) {
            digitSum = m;
            if (l1 != null) {
                digitSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                digitSum += l2.val;
                l2 = l2.next;
            }
            curValue = digitSum % 10;
            if (digitSum > 9) {
                m = 1;
            } else {
                m = 0;
            }
            if (head == null) {
                head = tail = new ListNode(curValue);
            } else {
                tail.next = new ListNode(curValue);
                tail = tail.next;
            }
        }
        if (m > 0) {
            tail.next = new ListNode(m);
        }
        return head;
    }
}
