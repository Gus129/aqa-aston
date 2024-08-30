package org.goose.Lesson_14.junit_5;

import java.math.BigInteger;

public class Calculator {
    public static BigInteger factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Число должно быть НЕотрицательным");
        }
        if (num <= 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(num).multiply(factorial(num - 1));
        }
    }
}