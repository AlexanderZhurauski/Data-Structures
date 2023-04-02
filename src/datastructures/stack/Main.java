package datastructures.stack;

import datastructures.stack.api.IStack;
import datastructures.stack.impl.ArrayStack;

public class Main {

    public static void main(String[] args) {
        IStack<Integer> integerStack = new ArrayStack<>();

        integerStack.push(5);
        System.out.println("Pushed '5' onto the stack");
        integerStack.push(7);
        System.out.println("Pushed '7' onto the stack");
        integerStack.push(9);
        System.out.println("Pushed '9' onto the stack");

        System.out.println("Capacity: " + integerStack.capacity());
        System.out.println("Size: " + integerStack.size());
        System.out.println("isEmpty: " + integerStack.isEmpty());
        System.out.println("Peek: " + integerStack.peek());
        System.out.println("Element: " + integerStack.pop());
        System.out.println("Element: " + integerStack.pop());
        System.out.println("Element: " + integerStack.pop());
    }
}
