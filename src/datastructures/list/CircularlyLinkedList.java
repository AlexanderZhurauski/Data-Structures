package datastructures.list;

import datastructures.exceptions.EmptyListException;

public class CircularlyLinkedList<E> implements ICircularlyLinkedList<E> {

    private Node<E> tail;
    private int size;

    public CircularlyLinkedList() {
        this.tail = null;
    }

    @Override
    public void rotate() {
        if (isEmpty()) {
            throw new EmptyListException("You cannot rotate an empty list!");
        }
        this.tail.setNext(this.tail.getNext());
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            this.tail = newNode;
            this.tail.setNext(newNode);
        } else {
            Node<E> head = this.tail.getNext();
            this.tail = newNode;
            newNode.setNext(head);
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        addFirst(element);
        this.tail = this.tail.getNext();
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {

    }
}
