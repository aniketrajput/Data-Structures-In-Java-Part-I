package com.home.maxiteminstack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        MaxItemStack maxItemStack = new MaxItemStack();
        maxItemStack.push(10);
        maxItemStack.push(50);
        maxItemStack.push(20);
        maxItemStack.push(70);
        maxItemStack.push(40);
        maxItemStack.push(10);

        System.out.println(maxItemStack.getMax());
    }
}
