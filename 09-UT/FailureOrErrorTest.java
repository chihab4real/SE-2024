package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class FailureOrErrorTest {


    @Test
    void test1() {
        assertFalse(true);
    }

    @Test
    void test2(){
        throw new RuntimeException("Arbitrary exception");
    }

    @Test
    void test3(){
        try {
            assertFalse(true);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
