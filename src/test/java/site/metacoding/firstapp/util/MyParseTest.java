package site.metacoding.firstapp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyParseTest {

    @Test
    public void changeStringToInt_Test() {
        // given
        String value = "1";

        // when
        int result = Integer.parseInt(value);

        // then
        assertEquals(1, result);
    }
}
