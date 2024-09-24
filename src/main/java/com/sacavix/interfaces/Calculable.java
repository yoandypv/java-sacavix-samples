package com.sacavix.interfaces;

// Interface with generic type
public interface Calculable<T extends Number> {
     T sum(T a, T b);
     T multiply(T a, T b);
     T divide(T a, T b);
     T minus(T a, T b);
}
