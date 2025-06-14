package com.leetcode.array;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram("anagram", "nagaram");
    }

    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            chars[c - 'a']++;
        }
        char[] tChars = t.toCharArray();
        for (char tc : tChars) {
            chars[tc - 'a']--;
        }

        for (int num : chars) {
            if (num != 0)
                return false;
        }
        return true;
    }
}
