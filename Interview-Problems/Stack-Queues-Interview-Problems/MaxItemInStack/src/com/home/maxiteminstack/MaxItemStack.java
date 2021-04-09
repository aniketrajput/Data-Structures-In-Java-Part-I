package com.home.maxiteminstack;

import java.util.Stack;

public class MaxItemStack {

    Stack<Integer> stack = new Stack<>();
    int max = 0;

    public void push(int item){

        if (item > max){
            max = item;
        }

        stack.add(item);
    }

    public int getMax(){
       return max;
    }
}
