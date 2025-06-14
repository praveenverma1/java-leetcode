package com.leetcode.array;

public class FindTheDifference {
    public static void main(String[] args) {
        FindTheDifference findTheDifference = new FindTheDifference();
        char result = findTheDifference.findTheDifference("abcd", "abcde");
        System.out.println(result);
    }

    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        char charAdded = 0;
        for (char tc : tChars)
            chars[tc - 'a']++;
        for (char sc : sChars)
            chars[sc - 'a']--;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 1) {
                int val = (int) 'a' + i;
                charAdded = (char) val;
            }
        }
        return charAdded;
    }
}
