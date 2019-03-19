package com.algorithm.leetcode.easy;

import com.algorithm.model.ListNode;

public class LeetCode160_IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int aLen = 0;
        int bLen = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            aLen++;
            pA = pA.next;
        }
        while (pB != null) {
            bLen++;
            pB = pB.next;
        }
        ListNode longList;
        ListNode shortList;
        if (aLen > bLen) {
            longList = headA;
            shortList = headB;
        } else {
            longList = headB;
            shortList = headA;
        }
        for (int i = 0; i < Math.abs(aLen - bLen); i++) {
            if (longList != null) {
                longList = longList.next;
            }
        }
        for (int i = 0; i < Math.min(aLen, bLen); i++) {
            if (longList == shortList) {
                return longList;
            }
            if (longList != null) {
                longList = longList.next;
            }
            if (shortList != null) {
                shortList = shortList.next;
            }
        }
        return null;
    }
}
