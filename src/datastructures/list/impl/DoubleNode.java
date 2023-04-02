package datastructures.list.impl;

public class DoubleNode<E> {

    private E data;
    private DoubleNode<E> next;
    private DoubleNode<E> prev;

    public DoubleNode() {
    }
    public DoubleNode(E data) {
        this.data = data;
    }
    public DoubleNode(DoubleNode<E> next, DoubleNode<E> prev) {
        this.next = next;
        this.prev = prev;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DoubleNode<E> getNext() {
        return this.next;
    }

    public void setNext(DoubleNode<E> next) {
        this.next = next;
    }

    public DoubleNode<E> getPrev() {
        return this.prev;
    }

    public void setPrev(DoubleNode<E> prev) {
        this.prev = prev;
    }
}
