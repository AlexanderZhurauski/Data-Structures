package datastructures.list;

import datastructures.list.api.IList;
import datastructures.list.impl.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        IList<Integer> integerList = new SinglyLinkedList<>();
        integerList.addLast(5);
        integerList.addLast(7);
        integerList.addLast(9);

        System.out.println("First: " + integerList.getFirst());
        System.out.println("Second: " + integerList.get(1));
        System.out.println("Last: " + integerList.getLast());
        System.out.println("Contains 7: " + integerList.contains(7));
        System.out.println("Is Empty: " + integerList.isEmpty());
        System.out.println("Size: " + integerList.size());
        System.out.println("Index of 9: " + integerList.indexOf(9));
    }
}
