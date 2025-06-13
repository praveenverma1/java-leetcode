package com.testquestions;

/*
 * If a variable is camel case
 * convert it to snake case
 * if its snake case 
 * convert it to camel case
 */
public class CppToJava {

    public static void main(String[] args) {
        CppToJava obj = new CppToJava();
        String reSult = obj.convertVariable("thisIsAVariable");
        System.out.println(reSult);
    }

    public String convertVariable(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        if (input.contains("_")) {
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length;) {
                if (chars[i] == '_') {
                    stringBuilder.append(Character.toUpperCase(chars[i + 1]));
                    i = i + 2;
                } else {
                    stringBuilder.append(chars[i]);
                    i++;
                }
            }

        } else {
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    stringBuilder.append('_')
                            .append(Character.toLowerCase(chars[i]));
                } else {
                    stringBuilder.append(chars[i]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
