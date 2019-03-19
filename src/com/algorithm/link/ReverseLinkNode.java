package com.algorithm.link;

import com.algorithm.model.LinkNode;
import com.algorithm.utils.LinkUtil;

/**
 * 链表反转
 * 1->2->3->4
 */
public class ReverseLinkNode {
    public static LinkNode reverse(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode pre = null;
        LinkNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static LinkNode reverse2(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode newLink = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newLink;
    }

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkNode head = reverse(node1);
        LinkUtil.printLinkNode(head);
        head = reverse2(head);
        LinkUtil.printLinkNode(head);
    }
}
