package datastructures.queue.impl;

import datastructures.list.api.IList;
import datastructures.list.impl.SinglyLinkedList;
import datastructures.queue.api.IQueue;

public class LinkedQueue<E> implements IQueue<E> {

    private IList<E> listAdapter;

    public LinkedQueue() {
        this.listAdapter = new SinglyLinkedList<>();
    }

    public LinkedQueue(IList<E> listAdapter) {
        this.listAdapter = listAdapter;
    }

    @Override
    public void enqueue(E element) {
        this.listAdapter.addLast(element);
    }

    @Override
    public E dequeue() {
        return this.listAdapter.removeFirst();
    }

    @Override
    public E peek() {
        return this.listAdapter.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.listAdapter.isEmpty();
    }

    @Override
    public int size() {
        return this.listAdapter.size();
    }
}
