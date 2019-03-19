package com.algorithm.offer;

import com.algorithm.model.LinkNode;
import com.algorithm.utils.LinkUtil;

/**
 * 删除链表中重复的结点，节点从小到大
 * 如：1 -> 2 -> 2 -> 3 -> 3 -> 4
 * 扩张： 如果链表中节点无序，怎么处理？
 */
public class Problem18 {
    public LinkNode removeDuplicateNode(LinkNode link) {
        if (link == null) {
            return null;
        }
        if (link.next == null) {
            return link;
        }
        LinkNode next = link.next;
        if (link.data == next.data) {
            while (next != null && link.data == next.data) {
                next = next.next;
            }
            return removeDuplicateNode(next);
        } else {
            link.next = removeDuplicateNode(next);
            return link;
        }
    }

    public static void main(String[] args) {
        LinkNode node0 = new LinkNode(1);
        LinkNode node1 = new LinkNode(2);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(3);
        LinkNode node5 = new LinkNode(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LinkUtil.printLinkNode(node0);
        Problem18 problem18 = new Problem18();
        System.out.println("\n");
        LinkUtil.printLinkNode(problem18.removeDuplicateNode(node0));
    }
}
