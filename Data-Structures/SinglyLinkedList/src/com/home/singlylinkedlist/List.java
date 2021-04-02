package com.home.singlylinkedlist;

public interface List<T extends Comparable<T>> {

    public int size();

    public void insert(T data);

    public void remove(T data);

    public void traverse();

    public void insertAtEnd(T data);

}
