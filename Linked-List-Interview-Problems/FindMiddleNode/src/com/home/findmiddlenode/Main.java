package com.home.findmiddlenode;

public class Main {

    public static void main(String[] args) {

        List<Integer> myLinkedList = new LinkedList<>();

        myLinkedList.insertAtEnd(10);
        myLinkedList.insertAtEnd(30);
        myLinkedList.insertAtEnd(50);
        myLinkedList.insertAtEnd(70);
        myLinkedList.insertAtEnd(80);

        System.out.println(myLinkedList.getMiddleNode());
    }
}
