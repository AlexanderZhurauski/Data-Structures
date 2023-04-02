package datastructures.stack.impl;

import datastructures.list.api.IDoublyLinkedList;
import datastructures.list.impl.DoublyLinkedList;
import datastructures.stack.api.IStack;

public class LinkedStack<E> implements IStack<E> {

    private IDoublyLinkedList<E> listAdapter;

    public LinkedStack() {
        this.listAdapter = new DoublyLinkedList();
    }
    public LinkedStack(IDoublyLinkedList<E> listAdapter) {
        this.listAdapter = listAdapter;
    }

    @Override
    public void push(E element) {
        this.listAdapter.addFirst(element);
    }

    @Override
    public E pop() {
        return this.listAdapter.removeFirst();
    }

    @Override
    public int size() {
        return this.listAdapter.size();
    }

    @Override
    public int capacity() {
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.listAdapter.isEmpty();
    }

    @Override
    public E peek() {
        return this.listAdapter.getFirst();
    }
}
