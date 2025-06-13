package com.testquestions;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String input = "hello";
        Character c = IntStream.range(0, input.length())
                .mapToObj(i -> input.charAt(i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
        System.out.println(c);
    }

}
