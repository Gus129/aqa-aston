import org.goose.Lesson_14.junit5.Calculator;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorJunitTests {
    @Test
    void testFactorialOfZero() {
        assertEquals(BigInteger.ONE, Calculator.factorial(0), "Факториал 0 должен быть равен 1");
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(BigInteger.valueOf(5040), Calculator.factorial(7), "Факториал 7 должен быть равен 5040");
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(BigInteger.ONE, Calculator.factorial(1), "Факториал 1 должен быть равен 1");
    }

    @Test
    void testFactorialOfVeryBigNumber() {
        BigInteger expected = new BigInteger("8841761993739701954543616000000");
        assertEquals(expected, Calculator.factorial(29), "Факториал 29 должен быть равен 8841761993739701954543616000000");
    }

    @Test
    void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.factorial(-1);
        }, "Факториал отрицательного числа должен выбрасывать исключение IllegalArgumentException");
    }

    @Test
    void testNegativeCheckFactorialOfThree() {
        BigInteger actualResult = Calculator.factorial(3);
        BigInteger incorrectResult = BigInteger.valueOf(4);

        if (!actualResult.equals(incorrectResult)) {
            assertNotEquals(incorrectResult, actualResult, "!3 не должен быть равен 4");
        } else {
            fail("!3 волшебным образом вычислен как 4");
        }
    }
}