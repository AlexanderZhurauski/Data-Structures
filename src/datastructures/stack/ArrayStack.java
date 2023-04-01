package datastructures.stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements IStack<E> {

    private static final int DEFAULT_CAPACITY = 1000;
    private int topIndex = -1;
    private final E[] data;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
    }
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) {
        if (size() >= capacity()) {
            throw new IndexOutOfBoundsException();
        }
        this.data[++topIndex] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E objectToReturn = this.data[this.topIndex];
        this.data[this.topIndex--] = null;
        return objectToReturn;
    }

    @Override
    public int size() {
        return this.topIndex + 1;
    }

    @Override
    public int capacity() {
        return this.data.length;
    }

    @Override
    public boolean isEmpty() {
        return this.topIndex == -1;
    }

    @Override
    public E peek() {
        return this.data[this.topIndex];
    }
}
