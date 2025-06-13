package com.javaconcepts;

public class MethodHiding {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.show();
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child static method");
    }
}

class Parent {
    static void show() {
        System.out.println("Parent static show");
    }
}