package com.algorithm.offer;

import com.algorithm.model.LinkNode;
import com.algorithm.utils.LinkUtil;

public class Problem25 {
    public LinkNode merge(LinkNode a, LinkNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        LinkNode c;
        if (a.data <= b.data) {
            c = a;
            a = a.next;
        } else {
            c = b;
            b = b.next;
        }
        LinkNode head = c;
        while (true) {
            if (a == null) {
                c.next = b;
                break;
            }
            if (b == null) {
                c.next = a;
                break;
            }
            if (a.data <= b.data) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }
            c = c.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node3 = new LinkNode(3);
        LinkNode node5 = new LinkNode(5);
        LinkNode node2 = new LinkNode(2);
        LinkNode node4 = new LinkNode(4);
        LinkNode node6 = new LinkNode(6);
        node1.next = node3;
        node3.next = node5;
        node2.next = node4;
        node4.next = node6;
        Problem25 problem25 = new Problem25();
        LinkUtil.printLinkNode(problem25.merge(node1, node2));
    }
}
