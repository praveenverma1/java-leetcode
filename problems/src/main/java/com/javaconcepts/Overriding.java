package com.javaconcepts;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Overriding {
    public static void main(String[] args) {
        Parent obj = new Child();
        try {
            obj.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Parent {
    void show() throws IOException {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void show() throws FileNotFoundException {
        System.out.println("Child");
    }
}