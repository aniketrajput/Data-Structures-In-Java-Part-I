package com.home.bst;

public interface Tree<T> {

    public void insert(T data);

    public void remove(T data);

    public void traversal();

    public T minItem();

    public T maxItem();

}
