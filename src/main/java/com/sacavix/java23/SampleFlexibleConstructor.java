package com.sacavix.java23;


import java.math.BigDecimal;

class PositiveBigDecimal extends BigDecimal {

    // JEP 482 - Constructores flexibles
    public PositiveBigDecimal(Long val) {
        if (val.compareTo(0L) < 0) {
            throw new ArithmeticException("Negative numbers are not allowed");
        }
        super(val);
    }
}

public class SampleFlexibleConstructor {

    public static void main(String[] args) {
        PositiveBigDecimal p = new PositiveBigDecimal(5L);
        PositiveBigDecimal p2 = new PositiveBigDecimal(-1L);

        System.out.println(p);


    }
}
