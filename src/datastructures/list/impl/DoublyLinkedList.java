package datastructures.list.impl;

import datastructures.exceptions.EmptyListException;
import datastructures.list.api.IDoublyLinkedList;

public class DoublyLinkedList<E> implements IDoublyLinkedList<E> {

    private DoubleNode<E> header;
    private DoubleNode<E> trailer;
    private int size;

    public DoublyLinkedList() {
        this.header = new DoubleNode<>();
        this.trailer = new DoubleNode<>();
        this.header.setNext(this.trailer);
        this.trailer.setPrev(this.header);
    }

    @Override
    public void addFirst(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        
        DoubleNode<E> newNode = new DoubleNode<>(element);
        if (isEmpty()) {
            this.header.setNext(newNode);
            this.trailer.setPrev(newNode);
        } else {
            newNode.setNext(this.header.getNext());
            this.header.setNext(newNode);
        }
    }

    @Override
    public void addLast(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        DoubleNode<E> newNode = new DoubleNode<>(element);
        if (isEmpty()) {
            this.header.setNext(newNode);
            this.trailer.setPrev(newNode);
        } else {
            newNode.setPrev(this.trailer.getPrev());
            this.trailer.setPrev(newNode);
        }
    }

    @Override
    public void add(int index, E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (isEmpty() && index == 0) {
            addFirst(element);
        }

        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index '" + index
                    + "' is out of bounds for a list of size '" + this.size + "'!");
        }

        DoubleNode<E> currentNode = this.header.getNext();
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        DoubleNode<E> newNode = new DoubleNode<>(element);
        newNode.setNext(currentNode);
        newNode.setPrev(currentNode.getPrev());
        currentNode.setPrev(newNode);
    }

    @Override
    public E get(int index) {
        //TODO
        return null;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new EmptyListException("Cannot acquire the first element of an empty list!");
        }
        return this.header.getNext().getData();
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new EmptyListException("Cannot acquire the first element of an empty list!");
        }
        return this.trailer.getPrev().getData();
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

        DoubleNode<E> nodeToChange = this.header.getNext();
        int currentIndex = 0;
        while (currentIndex < index) {
            nodeToChange = nodeToChange.getNext();
            currentIndex++;
        }

        nodeToChange.setData(element);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new EmptyListException("Cannot acquire the first element of an empty list!");
        }

        DoubleNode<E> nodeToRemove = this.header.getNext();
        E returnValue = nodeToRemove.getData();
        this.header.setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrev(this.header);

        return returnValue;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new EmptyListException("Cannot acquire the first element of an empty list!");
        }

        DoubleNode<E> nodeToRemove = this.trailer.getPrev();
        E returnValue = nodeToRemove.getData();
        this.trailer.setPrev(nodeToRemove.getPrev());
        nodeToRemove.getPrev().setNext(this.trailer);

        return returnValue;
    }

    @Override
    public E remove(int index) {
        if (isEmpty()) {
            throw new EmptyListException("Cannot acquire an element of an empty list!");
        }

        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index '" + index
                    + "' is out of bounds for a list of size '" + this.size + "'!");
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        }

        DoubleNode<E> currentNode = this.header.getNext();
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        currentNode.getPrev().setNext(currentNode.getNext());
        currentNode.getNext().setPrev(currentNode.getPrev());
        this.size--;

        return currentNode.getData();
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (isEmpty()) {
            return -1;
        }

        DoubleNode<E> currentNode = this.header.getNext();
        int index = 0;
        while (currentNode != null) {
            if (element.equals(currentNode.getData())) {
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
        this.header.setNext(this.trailer);
        this.trailer.setPrev(this.header);
        this.size = 0;
    }
}
