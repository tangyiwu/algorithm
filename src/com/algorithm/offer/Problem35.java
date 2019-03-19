package com.algorithm.offer;


import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。
 */
public class Problem35 {
    private static class ComplexLinkNode {
        private int value;
        private ComplexLinkNode next;
        private ComplexLinkNode random;

        public ComplexLinkNode(int value) {
            this.value = value;
        }
    }

    private Map<ComplexLinkNode, ComplexLinkNode> copyMap = new HashMap<>();
    private Map<ComplexLinkNode, ComplexLinkNode> nextPathMap = new HashMap<>();
    private Map<ComplexLinkNode, ComplexLinkNode> randomPathMap = new HashMap<>();

    public ComplexLinkNode copy(ComplexLinkNode linkList) {
        if (linkList == null) {
            return null;
        }
        copyMap.clear();
        nextPathMap.clear();
        randomPathMap.clear();
        ComplexLinkNode head = new ComplexLinkNode(linkList.value);
        copyMap.put(linkList, head);
        dealNode(linkList);
        copyMap.clear();
        nextPathMap.clear();
        randomPathMap.clear();
        return head;
    }

    private void dealNode(ComplexLinkNode old) {
        if (old == null || copyMap.get(old) == null) {
            return;
        }
        ComplexLinkNode copy = copyMap.get(old);
        ComplexLinkNode oldNext = old.next;
        ComplexLinkNode oldRand = old.random;

        if (oldNext != null && copyMap.get(oldNext) == null) {
            copy.next = new ComplexLinkNode(oldNext.value);
            copyMap.put(oldNext, copy.next);
            nextPathMap.put(old, copy);
            dealNode(oldNext);
        }
        if (oldRand != null && copyMap.get(oldRand) == null) {
            copy.random = new ComplexLinkNode(oldRand.value);
            copyMap.put(oldRand, copy.next);
            randomPathMap.put(old, copy);
            dealNode(oldRand);
        }
        if (!nextPathMap.containsKey(old) && old.next != null) {
            copy.next = copyMap.get(old.next);
            nextPathMap.put(old, copy);
        }
        if (!randomPathMap.containsKey(old) && old.random != null) {
            copy.random = copyMap.get(old.random);
            randomPathMap.put(old, copy);
        }
    }

    public void printComplexLink(ComplexLinkNode link) {
        while (link != null) {
            if (link.next != null) {
                System.out.println(link.value + "----->" + link.next.value);
            }
            if (link.random != null) {
                System.out.println(link.value + "- - ->" + link.random.value);
            }
            link = link.next;
        }
    }

    public static void main(String[] args) {
        ComplexLinkNode node1 = new ComplexLinkNode(1);
        ComplexLinkNode node2 = new ComplexLinkNode(2);
        ComplexLinkNode node3 = new ComplexLinkNode(3);
        ComplexLinkNode node4 = new ComplexLinkNode(4);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node4;
        node3.random = node1;
        node4.random = node2;

        Problem35 problem35 = new Problem35();
        ComplexLinkNode copy = problem35.copy(node1);
        problem35.printComplexLink(copy);
    }
}
