package com.leetcode.string;

import java.util.stream.Stream;

public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        String input = "   fly me   to   the moon  ";
        obj.lengthOfLastWord(input);
    }

    public int lengthOfLastWord(String s) {
        return Stream.of(s.split(" "))
                .filter(word -> !word.isEmpty())
                .reduce((a, b) -> b)
                .get()
                .length();
    }
}
