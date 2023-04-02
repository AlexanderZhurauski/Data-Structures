package datastructures.queue.impl;

import datastructures.exceptions.EmptyQueueException;
import datastructures.exceptions.FullQueueException;
import datastructures.queue.api.IQueue;

public class ArrayQueue<E> implements IQueue<E> {

    private static final int DEFAULT_CAPACITY = 1000;
    private E[] data;
    private int first;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        if (this.size == this.data.length) {
            throw new FullQueueException();
        }
        int target = (this.first + this.size) % this.data.length;
        this.data[target] = element;
        this.size++;
    }

    @Override
    public E dequeue() {
        if (this.size == 0) {
            throw new EmptyQueueException();
        }
        E returnValue = this.data[this.first];
        this.data[this.first] = null;
        this.first = (this.first + 1) % this.data.length;
        this.size--;
        return returnValue;
    }

    @Override
    public E peek() {
        if (this.size == 0) {
            throw new EmptyQueueException();
        }
        return this.data[this.first];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
}
