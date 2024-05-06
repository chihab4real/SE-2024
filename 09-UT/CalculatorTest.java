package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add() {

        assertEquals(4, calculator.add(2, 2));
        assertEquals(-20, calculator.add(-10, -10));
    }

    @Test
    void multiply() {

        assertEquals(4, calculator.multiply(2, 2));
        assertEquals(-100, calculator.multiply(10, -10));
    }

    @Test
    void addPositiveNumbers(){

        assertEquals(4, calculator.addPositiveNumbers(2, 2));
        assertThrows(IllegalArgumentException.class, () -> calculator.addPositiveNumbers(-2, 2));
        assertThrows(IllegalArgumentException.class, () -> calculator.addPositiveNumbers(2, -2));
        assertThrows(IllegalArgumentException.class, () -> calculator.addPositiveNumbers(-2, -2));
    }
}