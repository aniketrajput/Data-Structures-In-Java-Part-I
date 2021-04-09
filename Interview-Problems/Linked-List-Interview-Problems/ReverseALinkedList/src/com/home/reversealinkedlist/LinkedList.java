package com.home.reversealinkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> rootNode;
    private int numOfItems;

    @Override
    public void insert(T data) {

        numOfItems++;

        if (rootNode == null){
            rootNode = new Node<>(data);
        }
        else {
            insertAtBeginning(data);
        }
    }

    private void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(rootNode);
        rootNode = newNode;
    }

    @Override
    public void insertAtEnd(T data){
        Node<T> newNode = new Node<>(data);

        numOfItems++;

        if (rootNode == null){
            rootNode = newNode;
        }
        else {

            Node<T> tempNode = rootNode;

            while (tempNode.getNextNode() != null){
                tempNode = tempNode.getNextNode();
            }

            tempNode.setNextNode(newNode);
        }
    }

    private void insertAtEndRecursive(T data, Node<T> node) {

        if(node.getNextNode() != null){
            insertAtEndRecursive(data, node.getNextNode());
        }
        else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {

            if (rootNode == null) {
                return;
            }

            numOfItems--;

            if (rootNode.getData().compareTo(data) == 0) {
                rootNode = rootNode.getNextNode();
            }
            else {

                remove(data, rootNode, rootNode.getNextNode());
            }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {

        while (actualNode != null){

            if (actualNode.getData().compareTo(data) == 0) {

                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {
        if (rootNode == null) {
            return;
        }

        Node<T> actualNode = rootNode;

        while (actualNode != null){
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return numOfItems;
    }

    /*

    How to reverse a Linked List
    The task is to construct an in-place algorithm to reverse a singly linked list

	1. Naive solution: We consider all the nodes one by one then construct another linked list in reverse order

    Problem: it has O(N) memory complexity so it is not in-place

	2. Using pinters: We can achive an in-place algorithm that has O(N) linear running time complexity as well

    */

    @Override
    public void reverse() {

        Node<T> currentNode = this.rootNode;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        while (currentNode != null){
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        this.rootNode = previousNode;
    }
}












