package datastructures.list.impl;

import datastructures.exceptions.EmptyListException;
import datastructures.list.api.IList;

import java.util.Collection;

public class SinglyLinkedList<E> implements IList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public SinglyLinkedList(Collection<? extends E> collection) {
        this();
        if (!collection.isEmpty()) {
            Node<E> currentNode = new Node<>();
            for (E element : collection) {
                if (element == null) {
                    throw new NullPointerException();
                }
                currentNode.setData(element);
                currentNode.setNext(new Node<>());
                currentNode = currentNode.getNext();
                this.size++;
            }
            this.tail = currentNode;
        }
    }

    @Override
    public void addFirst(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (isEmpty()) {
            this.head = new Node<>(element);
            this.tail = this.head;
        } else {
            Node<E> newNode = new Node<>(element);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (isEmpty()) {
            this.head = new Node<>(element);
            this.tail = this.head;
        } else {
            Node<E> newNode = new Node<>(element);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
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

        Node<E> currentNode = this.head;
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

        Node<E> currentNode = this.head;
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
        return this.head.getData();
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

        if (isEmpty()) {
            throw new EmptyListException("Cannot change the value of an element of an empty list!");
        }

        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index '" + index
                    + "' is out of bounds for a list of size '" + this.size + "'!");
        }

        Node<E> currentNode = this.head;
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

        E returnValue = this.head.getData();
        this.head = this.head.getNext();
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

        Node<E> currentNode = this.head;
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
        return this.head == null;
    }

    @Override
    public void clear() {
        this.head = new Node<>();
        this.tail = new Node<>();
        this.size = 0;
    }
}
