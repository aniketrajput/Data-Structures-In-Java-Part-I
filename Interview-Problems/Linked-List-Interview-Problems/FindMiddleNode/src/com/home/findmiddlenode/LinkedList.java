package com.home.findmiddlenode;

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

    Middle Node in a Linked List
    The task is to find the middle node of a linked list without the need extra memory (so we are after an in-place algorithm)

	1. Naive solutio: We iterate through the list and count how many elements there are in total.
    Then traverse the list again and the node with index count/2 is the middle node.

            2. Using two pointers: We can use two pointers to get the middle node in O(N)
    First Pointer: traverse the linked list one node at a time
    Second Pointer: traverse the linked list two nodes at a time

    When the faster pointer reaches the end of the list then the slower pointer is pointing to the middle node.

    */

    @Override
    public Node<T> getMiddleNode() {

        Node<T> fastPointer = rootNode;
        Node<T> slowPointer = rootNode;

        while (fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {

            fastPointer = fastPointer.getNextNode().getNextNode();
            slowPointer = slowPointer.getNextNode();
        }

        return slowPointer;
    }

}
