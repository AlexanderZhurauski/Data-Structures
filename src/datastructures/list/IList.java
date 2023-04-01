package datastructures.list;

public interface IList<E> {

    void addFirst(E element);
    void addLast(E element);
    void add(int index, E element);
    E get(int index);
    E getFirst();
    E getLast();
    void set(int index, E element);
    void removeFirst();
    void remove(int index);
    int indexOf(E element);
    boolean contains(E element);
    int size();
    boolean isEmpty();
    void clear();
}
