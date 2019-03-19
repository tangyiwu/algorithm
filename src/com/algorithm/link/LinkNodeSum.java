package com.algorithm.link;

import com.algorithm.model.LinkNode;
import com.algorithm.utils.LinkUtil;

public class LinkNodeSum {
    /**
     * 链表加1
     */
    public static LinkNode linkNodeAddOne(LinkNode head) {
        if (head == null) {
            return new LinkNode(1);
        }
        head = ReverseLinkNode.reverse(head);
        int add = 1;
        LinkNode pre = null;
        LinkNode cur = head;
        while (add > 0) {
            if (cur == null) {
                cur = new LinkNode(add);
                if (pre != null) {
                    pre.next = cur;
                }
            }
            int sum = cur.data + add;
            cur.data = sum % 10;
            add = sum / 10;
            pre = cur;
            cur = cur.next;
        }
        head = ReverseLinkNode.reverse(head);
        return head;
    }

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        node1.next = node2;
        node2.next = node3;
        LinkNode head = linkNodeAddOne(node1);
        LinkUtil.printLinkNode(head);
        System.out.println();
        node2.next = new LinkNode(9);
        head = linkNodeAddOne(head);
        LinkUtil.printLinkNode(head);
    }
}
