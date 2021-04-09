package com.home.queueusingstack;

public class Main {

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(40);
        queue.enqueue(20);
        queue.enqueue(90);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(900);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
