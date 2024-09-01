package org.goose.Lesson_14.junit5;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int input = 29;
        BigInteger result = Calculator.factorial(input);
        System.out.println("Факториал числа " + input + " = " + result);
    }
}