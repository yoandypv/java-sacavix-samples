package com.sacavix.java23;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class SampleBasicGatherers {

    // JEP 473 Gatherers
    public static void main(String[] args) {
        List<List<Integer>> sample =  Stream.iterate(0, i -> i + 2)
                .gather(Gatherers.windowFixed(2))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(sample);
    }
}
