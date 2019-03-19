package com.algorithm.leetcode.easy;

import com.algorithm.model.ListNode;

/**
 * 判断回文链表
 * Example 1:
 * Input: 1->2
 * Output: false
 * <p>
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 */
public class LeetCode234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int len = length(head);
        ListNode backHalf = getBackHalfList(head, len);
        backHalf = reverse(backHalf);
        while (backHalf != null) {
            if (head.val != backHalf.val) {
                return false;
            }
            head = head.next;
            backHalf = backHalf.next;
        }
        return true;
    }

    private int length(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    private ListNode getBackHalfList(ListNode head, int len) {
        int begin = (len % 2 == 0) ? len / 2 : len / 2 + 1;
        int i = 0;
        while (i < begin) {
            head = head.next;
            i++;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        LeetCode234_PalindromeLinkedList palindromeLinkedList = new LeetCode234_PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(node0));
    }
}
