package datastructures.list;

import datastructures.list.api.IList;
import datastructures.list.impl.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        IList<Integer> integerList = new SinglyLinkedList<>();
        integerList.addLast(5);
        printList(integerList);
        integerList.addLast(7);
        printList(integerList);
        integerList.addLast(9);
        printList(integerList);
        integerList.addFirst(3);
        printList(integerList);

        System.out.println("First: " + integerList.getFirst());
        System.out.println("Second: " + integerList.get(1));
        System.out.println("Last: " + integerList.getLast());
        System.out.println("Contains 7: " + integerList.contains(7));
        System.out.println("Is Empty: " + integerList.isEmpty());
        System.out.println("Size: " + integerList.size());
        System.out.println("Index of 9: " + integerList.indexOf(9));
        printList(integerList);
    }

    public static <E> void printList(IList<E> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
