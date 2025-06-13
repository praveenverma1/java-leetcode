package com.testquestions;

import java.util.Arrays;

public class LowestClassAverage {

    public static void main(String[] args) {
        LowestClassAverage lowestClassAverage = new LowestClassAverage();
        // int n = 3;
        // int m = 5;
        // int[][] marks = new int[][] {
        // { 75, 76, 65, 87, 87 },
        // { 78, 76, 68, 56, 89 },
        // { 67, 87, 78, 77, 65 } };
        int n = 3;
        int m = 3;
        int[][] marks = new int[][] {
                { 50, 30, 70 },
                { 30, 70, 99 },
                { 99, 20, 30 } };
        int[] finalMarks = lowestClassAverage.sortStudentMarks(n, m, marks);
        Arrays.stream(finalMarks)
                .forEach(System.out::println);

    }

    public int[] sortStudentMarks(int n, int m, int[][] marks) {
        int[] totalMarks = new int[n];

        // calculate the lowest class average
        int lowestAverage = Integer.MAX_VALUE;
        int subjectToIgnore = 0;
        for (int i = 0; i < marks[0].length; i++) {
            int classMarks = 0;
            for (int j = 0; j < n; j++) {
                classMarks += marks[j][i];
            }
            if (classMarks < lowestAverage) {
                lowestAverage = classMarks;
                subjectToIgnore = i;
            }
        }
        for (int i = 0; i < n; i++) {
            int finalMarks = 0;
            for (int j = 0; j < marks[0].length; j++) {
                if (j != subjectToIgnore) {
                    finalMarks += marks[i][j];
                }
            }
            totalMarks[i] = finalMarks;
        }
        return totalMarks;
    }
}
