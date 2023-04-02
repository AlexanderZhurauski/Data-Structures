package datastructures.list.api;

public interface IDoublyLinkedList<E> extends IList<E> {
    E removeLast();
    E remove(int index);
}
