package com.algorithm.leetcode.medium;

import com.algorithm.model.ListNode;

public class LeetCode142_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head, q = head;
        int pStep = 0, qStep = 0;
        boolean isCycle = false;
        while (p != null) {
            if (p.next == null) return null;
            p = p.next.next;
            pStep = pStep + 2;
            q = q.next;
            qStep = qStep+1;
            if (p == q && p != null)  {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            int cycleLength = pStep - qStep;
            p = head;
            q = head;
            while (cycleLength > 0) {
                p = p.next;
                cycleLength--;
            }
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return p;
        }
        return null;
    }
}
