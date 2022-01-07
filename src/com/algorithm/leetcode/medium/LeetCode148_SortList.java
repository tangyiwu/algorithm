package com.algorithm.leetcode.medium;

import com.algorithm.model.ListNode;

/**
 * 利用快速排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public class LeetCode148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        ListNode[] a = new ListNode[cnt];
        cur = head;
        cnt = 0;
        while (cur != null) {
            a[cnt++] = cur;
            cur = cur.next;
        }
        sort(a);
        head = a[0];
        ListNode pre = head;
        for (int i = 1; i < a.length; i++) {
            pre.next = a[i];
            pre = a[i];
        }
        a[cnt - 1].next = null;
        return head;
    }

    private void sort(ListNode[] nodes) {
        sort(nodes, 0, nodes.length - 1);
    }

    private void sort(ListNode[] nodes, int left, int right) {
        if (left < right) {
            int partition = partition(nodes, left, right);
            sort(nodes, left, partition - 1);
            sort(nodes, partition + 1, right);
        }
    }

    private int partition(ListNode[] nodes, int left, int right) {
        int cursor = nodes[left].val;
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nodes[j].val >= cursor) {
                j--;
            }

            while (i < j && nodes[i].val <= cursor) {
                i++;
            }
            swap(nodes, i, j);
        }
        swap(nodes, left, i);
        return j;
    }

    private void swap(ListNode[] nodes, int i, int j) {
        ListNode tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;
    }
}
