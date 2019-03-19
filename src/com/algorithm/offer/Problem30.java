package com.algorithm.offer;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 */
public class Problem30 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> helpStack = new Stack<>();
    private int min = Integer.MIN_VALUE;

    public void push(int e) {
        if (dataStack.isEmpty()) {
            min = e;
        } else {
            min = Math.min(min, e);
        }
        dataStack.push(e);
    }

    public int size() {
        return dataStack.size();
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    public int min() {
        if (!dataStack.isEmpty()) {
            return min;
        }
        throw new EmptyStackException();
    }

    public int pop() {
        int removed = dataStack.pop();
        if (!isEmpty()) {
            if (removed == min()) {
                findMin(removed);
            }
        } else {
            min = Integer.MIN_VALUE;
        }
        return removed;
    }

    private void findMin(int oldMin) {
        int m = dataStack.peek();
        while (!dataStack.isEmpty()) {
            int e = dataStack.pop();
            helpStack.push(e);
            if (oldMin == e) {
                min = e;
                break;
            }
            if (e < m) {
                m = e;
            }
        }
        min = m;
        while (!helpStack.isEmpty()) {
            dataStack.push(helpStack.pop());
        }
    }

    public static void main(String[] args) {
        Problem30 stack = new Problem30();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(6);
        stack.push(3);
        stack.push(2);
        System.out.println("min = " + stack.min());
        System.out.println("pop = " + stack.pop());
        System.out.println("min = " + stack.min());
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("min = " + stack.min());
    }
}
