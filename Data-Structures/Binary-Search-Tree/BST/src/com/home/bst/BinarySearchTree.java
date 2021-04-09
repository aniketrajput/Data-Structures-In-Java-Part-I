package com.home.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        if (root == null){
            root = new Node<T>(data, null);
        }
        else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {

        if (node.getData().compareTo(data) > 0){        //node data is greater than given data

            if (node.getLeftChild() != null){           //if left child is not null then move to left child, if it is null then we need to insert new node in left child
                insert(data, node.getLeftChild());
            }
            else {
                node.setLeftChild( new Node<T>(data, node));
            }
        }else {

            if (node.getRightChild() != null){
                insert(data, node.getRightChild());
            }
            else {
                node.setRightChild( new Node<T>(data, node));
            }
        }

    }

    @Override
    public void remove(T data) {
        if(root != null)
            remove(data, root);
    }

    private void remove(T data, Node<T> node) {

        if(node == null) return;

        if (node.getData().compareTo(data) > 0){        //go left
            remove(data, node.getLeftChild());
        }
        else if(node.getData().compareTo(data) < 0) {   //go right
            remove(data, node.getRightChild());
        }
        else {                                          //node found

            if (node.getLeftChild() == null && node.getRightChild() == null) {   //leaf node

                System.out.println("Removing leaf node...");

                Node<T> parent = node.getParent();

                if (parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(null);
                }
                else if (parent != null && parent.getRightChild() == node){
                    parent.setRightChild(null);
                }

                //if it a root node then parent will be null
                if (parent == null){
                    root = null;
                }

                node = null;    //make node eligible for GC
            }
            else if(node.getLeftChild() == null && node.getRightChild() != null) {      //node with single right child
                System.out.println("Removing node with single right child...");

                Node<T> parent = node.getParent();

                if (parent != null && parent.getLeftChild() == node){       //node is left child of parent
                    parent.setLeftChild(node.getRightChild());              //set parent left child now to node's left child
                }
                else if(parent != null && parent.getRightChild() == node){  //node is right child of parent
                    parent.setRightChild(node.getRightChild());
                }

                if(parent == null){
                    root = node.getRightChild();
                }

                node.getRightChild().setParent(parent);     //upate right child's parent
                node = null;

            }
            else if(node.getLeftChild() != null && node.getRightChild() == null) {      //node with single left child
                System.out.println("Removing node with single left child...");

                Node<T> parent = node.getParent();

                if (parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getLeftChild());
                }
                else if (parent != null && parent.getRightChild() == null){
                    parent.setRightChild(node.getLeftChild());
                }

                if (parent == null){
                    root = node.getLeftChild();
                }

                node.getLeftChild().setParent(parent);
                node = null;
            }
            else {  //node with 2 children

                System.out.println("Removing a node with 2 children...");

                Node<T> predecessor = getPredecessor(node.getLeftChild());  //max item in left subtree of the node we want to remove

                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                remove(data, predecessor);
            }
        }
    }

    private Node<T> getPredecessor(Node<T> node) {

        if (node.getRightChild() != null)
            return getPredecessor(node.getRightChild());

        return node;
    }

    @Override
    public void traversal() {

        if (root == null)
            return;

        traversal(root);
    }

    private void traversal(Node<T> node) {

        if (node.getLeftChild() != null)
            traversal(node.getLeftChild());

        System.out.println(node + " - ");

        if (node.getRightChild() != null)
            traversal(node.getRightChild());
    }

    @Override
    public T minItem() {

        if(root == null)
            return null;

        return minItem(root);
    }

    private T minItem(Node<T> node) {
        if (node.getLeftChild() != null)
            return minItem(node.getLeftChild());

        return node.getData();
    }

    @Override
    public T maxItem() {

        if(root == null)
            return null;

        return maxItem(root);
    }

    private T maxItem(Node<T> node) {
        if (node.getRightChild() != null)
            maxItem(node.getRightChild());

        return node.getData();
    }
}
