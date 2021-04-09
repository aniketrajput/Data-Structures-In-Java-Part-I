package com.home.bst;

public class Main {

    public static void main(String[] args) {
        /*
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(90);
        bst.insert(50);
        bst.insert(60);
        bst.insert(100);
        bst.insert(20);

        bst.traversal();

        bst.remove(10);

        bst.traversal();
        */

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(new Person("YYY", 30));
        bst.insert(new Person("RRR", 12));
        bst.insert(new Person("SSS", 55));
        bst.insert(new Person("XXX", 27));
        bst.insert(new Person("PPP", 16));
        bst.insert(new Person("QQQ", 36));

        bst.traversal();

        Person removePerson = new Person("QQQ", 36);
        bst.remove(removePerson);

        bst.traversal();
    }
}
