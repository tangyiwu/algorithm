package com.algorithm.offer;

import com.algorithm.model.LinkNode;

/**
 * 从尾到头反过来打印出每个结点的值。
 */
public class Problem6 {
    public void printLinkListFromTail(LinkNode head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            System.out.print(head.data + " ");
            return;
        }
        printLinkListFromTail(head.next);
        System.out.print(head.data + " ");
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
        Problem6 problem6 = new Problem6();
        problem6.printLinkListFromTail(a);
    }
}
