package com.testquestions;

import java.time.Duration;
import java.time.LocalTime;

public class LocalTimePlus {
    public static void main(String[] args) {
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        System.out.println(finalTime);
    }
}
