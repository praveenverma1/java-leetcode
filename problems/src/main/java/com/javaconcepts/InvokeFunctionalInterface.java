package com.javaconcepts;

public class InvokeFunctionalInterface {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        Integer r = sum.apply(4, 5, 6);
        System.out.println(r);
    }
}
