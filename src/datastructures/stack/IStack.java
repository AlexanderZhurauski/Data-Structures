package datastructures.stack;

public interface IStack<E> {
    void push(E element);
    E pop();
    int size();
    int capacity();
    boolean isEmpty();
    E peek();
}
