package com.algorithm.queue;

public interface Queue<E> {
    void push(E element);

    E pop();

    boolean isEmpty();

    int size();
}
