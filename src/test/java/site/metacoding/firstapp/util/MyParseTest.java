package site.metacoding.firstapp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyParseTest {
    @Test
    public void changeStringToInt_test() {
        // given (매개변수)
        String value = "1";

        // when (test)
        int result = Integer.parseInt(value);

        // then (verify)
        assertEquals(1, result);
    }
}