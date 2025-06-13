package com.javaconcepts;

/*
 * This is a FunctionalInterface 
 * that takes three arguments and processes them
 * and finally gives the result as R
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
