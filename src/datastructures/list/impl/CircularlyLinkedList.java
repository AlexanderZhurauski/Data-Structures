package datastructures.list.impl;

import datastructures.exceptions.EmptyListException;
import datastructures.list.api.ICircularlyLinkedList;

public class CircularlyLinkedList<E> implements ICircularlyLinkedList<E> {

    private Node<E> tail;
    private int size;

    public CircularlyLinkedList() {
    }

    @Override
    public void rotate() {
        if (isEmpty()) {
            throw new EmptyListException("You cannot rotate an empty list!");
        }
        this.tail = this.tail.getNext();
    }

    @Override
    public void addFirst(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

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
        rotate();
    }

    @Override
    public void add(int index, E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (isEmpty() && index == 0) {
            addFirst(element);
            return;
        }

        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index '" + index
                    + "' is out of bounds for a list of size '" + this.size + "'!");
        }

        if (index == this.size - 1) {
            addLast(element);
        }

        Node<E> currentNode = this.tail.getNext();
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        Node<E> newNode = new Node<>(element);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        this.size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index '" + index
                    + "' is out of bounds for a list of size '" + this.size + "'!");
        }

        Node<E> currentNode = this.tail.getNext();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new EmptyListException("Cannot acquire the first element of an empty list!");
        }
        if (size() == 1) {
            return this.tail.getData();
        } else {
            return this.tail.getNext().getData();
        }
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new EmptyListException("Cannot acquire the last element of an empty list!");
        }
        return this.tail.getData();
    }

    @Override
    public void set(int index, E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index '" + index
                    + "' is out of bounds for a list of size '" + this.size + "'!");
        }

        Node<E> currentNode = this.tail.getNext();
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        currentNode.setData(element);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new EmptyListException("Cannot remove the first element of an empty list!");
        }

        if (this.size == 1) {
            E returnValue = this.tail.getData();
            this.tail = null;
            this.size--;
            return returnValue;
        }

        E returnValue = this.tail.getData();
        this.tail.setNext(this.tail.getNext().getNext());
        if (this.tail.getNext() == null) {
            this.tail.setNext(this.tail);
        }
        this.size--;
        return returnValue;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (isEmpty()) {
            return -1;
        }

        Node<E> currentNode = this.tail.getNext();
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getData().equals(element)) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
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
        this.tail = null;
        this.size = 0;
    }
}
