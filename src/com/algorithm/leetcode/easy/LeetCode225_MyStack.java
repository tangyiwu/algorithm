package com.algorithm.leetcode.easy;

import java.util.LinkedList;

public class LeetCode225_MyStack {
    private LinkedList<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public LeetCode225_MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.removeLast();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peekLast();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode225_MyStack stack = new LeetCode225_MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
