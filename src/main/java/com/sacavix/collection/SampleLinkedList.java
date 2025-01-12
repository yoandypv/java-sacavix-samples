package com.sacavix.collection;

import java.util.LinkedList;
import java.util.List;

public class SampleLinkedList {

    public static void list() {

        // Add Item
        List<String> stringList = new LinkedList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        stringList.forEach(System.out::println);

        stringList.clear();
    }

    public static void stack() {

        LinkedList<String> stack = new LinkedList<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Stack items: " + stack);

        // Top example
        String topElement = stack.pop();
        System.out.println("Top item: " + topElement);
        System.out.println("Stack items: " + stack);

        // See the top element
        System.out.println("Top item: " + stack.peek());
    }


    public static void queue() {
        LinkedList<String> queue = new LinkedList<>();

        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        System.out.println("Queue items: " + queue);

        // dequeue first item A
        String firstElement = queue.poll();
        System.out.println("First item: " + firstElement);
        System.out.println("Queue items: " + queue);

        // See first element
        System.out.println("First item: " + queue.peek());
    }


    public static void main(String[] args) {
       list();
    }
}
