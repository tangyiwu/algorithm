package com.algorithm.offer;

import com.algorithm.model.LinkNode;

/**
 * 两个链表的第一个公共结点
 */
public class Problem52 {
    public LinkNode firstCommonLinkNode(LinkNode first, LinkNode second) {
        if (first == null || second == null) {
            return null;
        }
        int firstLen = linkNodeLen(first);
        int secondLen = linkNodeLen(second);
        LinkNode longLink;
        LinkNode shortLink;
        int prevStep = 0;
        if (firstLen > secondLen) {
            prevStep = firstLen - secondLen;
            longLink = first;
            shortLink = second;
        } else {
            prevStep = secondLen - firstLen;
            longLink = second;
            shortLink = first;
        }
        while (prevStep > 0) {
            longLink = longLink.next;
            prevStep--;
        }
        while (longLink != null) {
            if (longLink == shortLink) {
                return longLink;
            }
            longLink = longLink.next;
            shortLink = shortLink.next;
        }
        return null;
    }

    private int linkNodeLen(LinkNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        LinkNode a1 = new LinkNode(1);
        LinkNode a2 = new LinkNode(2);
        LinkNode c1 = new LinkNode(3);
        LinkNode c2 = new LinkNode(4);
        LinkNode c3 = new LinkNode(5);
        LinkNode b1 = new LinkNode(6);
        LinkNode b2 = new LinkNode(7);
        LinkNode b3 = new LinkNode(8);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        Problem52 problem52 = new Problem52();
        LinkNode node = problem52.firstCommonLinkNode(a1, b1);
        System.out.println(node.data);
    }
}
