package datastructures.list;

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
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
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
            throw new IndexOutOfBoundsException();
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
            throw new IndexOutOfBoundsException();
        }
        return this.head.getData();
    }
    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.tail.getData();
    }

    @Override
    public void set(int index, E element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
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
    public void removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        this.head = this.head.getNext();
        this.size--;
    }
    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            this.head = this.head.getNext();
            if (this.head == null) {
                this.tail = null;
            }
            this.size--;
            return;
        }

        if (index == this.size - 1) {
            this.tail = null;
            this.size--;
            return;
        }

        Node<E> currentNode = this.head;
        int currentIndex = 0;
        while (currentIndex < index - 1) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        currentNode.setNext(currentNode.getNext().getNext());
        this.size--;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
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
