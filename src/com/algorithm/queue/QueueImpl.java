package com.algorithm.queue;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
public class QueueImpl<E> implements Queue<E> {
    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    @Override
    public void push(E element) {
        stack1.push(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        E e = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return e;
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new QueueImpl<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println("size=" + queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println("size=" + queue.size());
        queue.push(6);
        queue.push(7);
        System.out.println("size=" + queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }
}
