package com.testquestions;

public class Multiplication
        implements mulint1, mulint2 {

    public static void main(String[] args) {
        Multiplication obj = new Multiplication();
        obj.result();
    }

    public void result() {
        mulint1.super.result();
        mulint2.super.result();
    }

}

interface mulint1 {
    default void result() {
        int x = 7;
        int y = 21;
        int result = x * y;
        System.out.println("Result is : " + result);
    }
}

interface mulint2 {
    default void result() {
        int x = 5;
        int y = 13;
        int result = x * y;
        System.out.println("Result is : " + result);
    }
}