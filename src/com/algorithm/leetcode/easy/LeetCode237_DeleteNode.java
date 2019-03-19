package com.algorithm.leetcode.easy;

import com.algorithm.model.ListNode;

/**
 * 1->2->3->4->5  3
 * 1->2->4->5
 */
public class LeetCode237_DeleteNode {
    public void deleteNode(ListNode node) {
        while (node.next != null && node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
