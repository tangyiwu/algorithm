package com.algorithm.utils;

import com.algorithm.model.LinkNode;
import com.algorithm.model.ListNode;

public class LinkUtil {
    public static void printLinkNode(LinkNode linkNode) {
        while (linkNode != null) {
            System.out.print(linkNode.data + " ");
            linkNode = linkNode.next;
        }
    }

    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println();
        System.out.print(head.val);
        while (head != null) {
            if (head.next != null) {
                System.out.print("->");
                System.out.print(head.next.val);
            }
            head = head.next;
        }
    }
}
