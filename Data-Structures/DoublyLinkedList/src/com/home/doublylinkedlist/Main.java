package com.home.doublylinkedlist;

public class Main {

    public static void main(String[] args) {
/*
        DoublyLinkedList<String> dll = new DoublyLinkedList<>()<>();

        dll.addLast("Kevin");
        dll.addLast("Daniel");
        dll.addLast("Ana");

        dll.removeLast();

        for(String name : dll)
            System.out.println(name);
            */

        DoublyLinkedList<String> names = new DoublyLinkedList<>();

        names.insert("Adam");
        names.insert("Kevin");
        names.insert("Ana");
        names.insert("Daniel");

        names.traverseForward();
    }
}
