package datastructures.queue.api;

public interface IQueue<E> {
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
}
