package com.algorithm.offer;

import com.algorithm.model.LinkNode;
import com.algorithm.utils.LinkUtil;

/**
 * 反转链表
 */
public class Problem24 {
    public LinkNode reverse(LinkNode linkNode) {
        if (linkNode == null || linkNode.next == null) {
            return linkNode;
        }
        LinkNode next = linkNode.next;
        linkNode.next = null;
        LinkNode reverse = reverse(next);
        next.next = linkNode;
        return reverse;
    }

    public static void main(String[] args) {
        LinkNode a = new LinkNode(1);
        LinkNode b = new LinkNode(2);
        LinkNode c = new LinkNode(3);
        LinkNode d = new LinkNode(4);
        LinkNode e = new LinkNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Problem24 problem24 = new Problem24();
        LinkUtil.printLinkNode(problem24.reverse(a));
    }
}
