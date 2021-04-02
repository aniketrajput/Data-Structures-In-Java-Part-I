package com.home.singlylinkedlist;

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

}
