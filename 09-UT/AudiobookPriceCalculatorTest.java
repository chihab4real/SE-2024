package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    private Audiobook audiobook;
    private AudiobookPriceCalculator calculator;

    @BeforeEach
    void setUp() {
        audiobook = new Audiobook("Book", 10.0);
        calculator = new AudiobookPriceCalculator();
    }


    @Test
    void testCalculateSubscriber() {

        Customer customer = new Customer("Customer1", Customer.LoyaltyLevel.STANDARD, true);


        assertEquals(0.0, calculator.calculate(customer, audiobook));
    }

    @Test
    void testCalculateSilverLoyaltyLevel() {

        Customer customer = new Customer("Customer2", Customer.LoyaltyLevel.SILVER, false);




        assertEquals(9.0, calculator.calculate(customer, audiobook));
    }

    @Test
    void testCalculateGoldLoyaltyLevel() {

        Customer customer = new Customer("Customer3", Customer.LoyaltyLevel.GOLD, false);


        assertEquals(8.0, calculator.calculate(customer, audiobook));
    }

    @Test
    void testCalculateRegularCustomer() {

        Customer customer = new Customer("Customer4", Customer.LoyaltyLevel.STANDARD, false);

        assertEquals(10.0, calculator.calculate(customer, audiobook));
    }
}