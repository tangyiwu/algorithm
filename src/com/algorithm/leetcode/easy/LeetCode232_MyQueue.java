package com.algorithm.leetcode.easy;

import java.util.Stack;

public class LeetCode232_MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> helpStack;

    public LeetCode232_MyQueue() {
        stack = new Stack<>();
        helpStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!stack.isEmpty()) {
            helpStack.push(stack.pop());
        }
        int result = helpStack.pop();
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!stack.isEmpty()) {
            helpStack.push(stack.pop());
        }
        int result = helpStack.peek();
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}
