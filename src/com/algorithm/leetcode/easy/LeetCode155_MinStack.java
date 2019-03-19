package com.algorithm.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class LeetCode155_MinStack {
    private static class MinStack {
        private PriorityQueue<Integer> minQueue;
        private Stack<Integer> stack;

        public MinStack() {
            minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            minQueue.add(x);
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            int removed = stack.pop();
            if (minQueue.peek() == removed) {
                minQueue.poll();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minQueue.peek();
        }
    }

    public static void main(String[] args) {

    }
}
