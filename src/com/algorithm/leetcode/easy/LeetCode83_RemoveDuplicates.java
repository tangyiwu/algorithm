package com.algorithm.leetcode.easy;

import com.algorithm.model.ListNode;
import com.algorithm.utils.LinkUtil;

public class LeetCode83_RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            cur.next = removeListNode(cur.next, cur.val);
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    private ListNode removeListNode(ListNode head, int value) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == value) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        ListNode next = tail.next;
        while (next != null) {
            if (next.val != value) {
                tail.next = next;
                tail = next;
            }
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode83_RemoveDuplicates removeDuplicates = new LeetCode83_RemoveDuplicates();
        ListNode a0 = new ListNode(1);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a0.next = a1;
        a1.next = a2;
        LinkUtil.printListNode(a0);
        LinkUtil.printListNode(removeDuplicates.deleteDuplicates(a0));

        ListNode b0 = new ListNode(1);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(3);
        b0.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        LinkUtil.printListNode(b0);
        LinkUtil.printListNode(removeDuplicates.deleteDuplicates2(b0));
    }

}
