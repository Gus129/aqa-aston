import org.goose.Lesson_14.testng.Calculator;

import java.math.BigInteger;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTestngTests {
    @Test
    public void testFactorialOfZero() {
        assertEquals(BigInteger.ONE, Calculator.factorial(0), "Факториал 0 должен быть равен 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(BigInteger.valueOf(5040), Calculator.factorial(7), "Факториал 7 должен быть равен 5040");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(BigInteger.ONE, Calculator.factorial(1), "Факториал 1 должен быть равен 1");
    }

    @Test
    public void testFactorialOfVeryBigNumber() {
        BigInteger expected = new BigInteger("8841761993739701954543616000000");
        assertEquals(expected, Calculator.factorial(29), "Факториал 29 должен быть равен 8841761993739701954543616000000");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число должно быть НЕотрицательным")
    public void testFactorialOfNegativeNumber() {
        Calculator.factorial(-1);
    }
}