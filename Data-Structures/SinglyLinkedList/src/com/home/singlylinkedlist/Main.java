package com.home.singlylinkedlist;

public class Main {

    public static void main(String[] args) {

//        List<Integer> myLinkedList = new LinkedList<>();

        /*
        myLinkedList.insert(10);
        myLinkedList.insert(30);
        myLinkedList.insert(50);
        myLinkedList.insert(70);
        myLinkedList.insert(80);
        */
/*

        myLinkedList.insertAtEnd(10);
        myLinkedList.insertAtEnd(30);
        myLinkedList.insertAtEnd(50);
        myLinkedList.insertAtEnd(70);
        myLinkedList.insertAtEnd(80);
*/


        List<Person> peopleList = new LinkedList<>();
        Person p1 = new Person(30, "Aniket");
        Person p2 = new Person(18, "Rani");
        Person p3 = new Person(52, "Suma");

        peopleList.insertAtEnd(p1);
        peopleList.insertAtEnd(p2);
        peopleList.insertAtEnd(p3);

        peopleList.remove(p2);

        peopleList.traverse();
    }
}
