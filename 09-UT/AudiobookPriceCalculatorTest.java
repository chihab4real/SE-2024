package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    Audiobook audiobook;
    AudiobookPriceCalculator calculator;

    @BeforeEach
    void setUp() {
        audiobook = new Audiobook("Book", 10.0);
       calculator = new AudiobookPriceCalculator();
    }


    @Test
    void testCalculateSubscriber() {

        Customer customer = new Customer("Customer1", Customer.LoyaltyLevel.STANDARD, true);

        double price = calculator.calculate(customer, audiobook);

        assertEquals(0.0, price);
    }

    @Test
    void testCalculateSilverLoyaltyLevel() {

        Customer customer = new Customer("Customer2", Customer.LoyaltyLevel.SILVER, false);


        double price = calculator.calculate(customer, audiobook);

        assertEquals(9.0, price);
    }

    @Test
    void testCalculateGoldLoyaltyLevel() {

        Customer customer = new Customer("Customer3", Customer.LoyaltyLevel.GOLD, false);


        double price = calculator.calculate(customer, audiobook);

        assertEquals(8.0, price);
    }

    @Test
    void testCalculateRegularCustomer() {

        Customer customer = new Customer("Customer4", Customer.LoyaltyLevel.STANDARD, false);


        double price = calculator.calculate(customer, audiobook);

        assertEquals(10.0, price);
    }
}