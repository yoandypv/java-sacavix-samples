package com.sacavix.collection;

import java.util.LinkedList;
import java.util.List;

public class SampleLinkedList {

    public static void main(String[] args) {

        // Add Item
        List<String> stringList = new LinkedList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        stringList.forEach(System.out::println);

        stringList.clear();
    }
}
