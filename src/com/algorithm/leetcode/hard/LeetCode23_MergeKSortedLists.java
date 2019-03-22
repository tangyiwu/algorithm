package com.algorithm.leetcode.hard;

import com.algorithm.model.ListNode;
import com.algorithm.utils.LinkUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;
        while (!finished(lists)) {
            int p = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                ListNode cur = lists[i];
                if (cur != null) {
                    if (cur.val <= min) {
                        min = cur.val;
                        p = i;
                    }
                }
            }
            if (head == null) {
                head = tail = new ListNode(min);
            } else {
                tail.next = new ListNode(min);
                tail = tail.next;
            }
            lists[p] = lists[p].next;
        }
        return head;
    }

    private boolean finished(ListNode[] lists) {
        for (ListNode listNode : lists) {
            if (listNode != null) {
                return false;
            }
        }
        return true;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            while (head != null) {
                queue.add(head);
                head = head.next;
            }
        }
        ListNode head = null;
        ListNode tail = null;
        while (!queue.isEmpty()) {
            if (head == null) {
                head = tail = new ListNode(queue.poll().val);
            } else {
                tail.next = new ListNode(queue.poll().val);
                tail = tail.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(-2);
        ListNode tail = list1;
        tail.next = new ListNode(-1);
        tail = tail.next;
        tail.next = new ListNode(-1);
        tail = tail.next;
        tail.next = new ListNode(-1);
        tail = tail.next;
        ListNode[] lists = new ListNode[2];
        lists[0] = list1;
        lists[1] = null;
        ListNode merge = new LeetCode23_MergeKSortedLists().mergeKLists2(lists);
        LinkUtil.printListNode(merge);
    }
}
