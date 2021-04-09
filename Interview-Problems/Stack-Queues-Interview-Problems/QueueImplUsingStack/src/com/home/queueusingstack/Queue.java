package com.home.queueusingstack;

import java.util.Stack;

public class Queue {

    Stack<Integer> enqueueStack = new Stack<>();
    Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int item){

        enqueueStack.push(item);
    }

    public int dequeue(){

        if (enqueueStack.isEmpty() && dequeueStack.isEmpty())
            throw new RuntimeException("Stacks are empty...");

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                int item = enqueueStack.pop();
                dequeueStack.push(item);
            }
        }

        return dequeueStack.pop();
    }
}
