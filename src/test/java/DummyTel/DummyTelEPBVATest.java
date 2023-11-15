package DummyTel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static DummyTel.DummyTel.getCallCost;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTelEPBVATest {
    /**
     * 2 inputs: Start time (s) and Duration (d)
     * <p>
     * s has 5 possible values: s < 0, 0 <= s < 8, 8 <= s < 18, 18 <= s <= 23:59, s > 23:59=>
     * d has 3 possible values: d > 60, 0 <= d <= 60, d < 0
     * 15 test cases (phan lop tuong duong manh)
     * 9 invalid classes
     * Cases:
     * <p>
     * //    1. s < 0,             d > 60
     * //    6. s < 0,             0 <= d <= 60
     * //   11. s < 0,             d < 0
     * <p>
     * //    2. 0 <= s < 8,         d > 60
     * //    7. 0 <= s < 8,         0 <= d <= 60
     * //   12. 0 <= s < 8,         d < 0
     * <p>
     * //    3. 8 <= s < 18,        d > 60
     * //    8. 8 <= s < 18,        0 <= d <= 60
     * //   13. 8 <= s < 18,        d < 0
     * <p>
     * //    4. 18 <= s <= 23:59,    d > 60
     * //    9. 18 <= s <= 23:59,    0 <= d <= 60
     * //   14. 18 <= s <= 23:59,    d < 0
     * <p>
     * //    5. s > 23:59,         d > 60
     * //   10. s > 23:59,         0 <= d <= 60
     * //   15. s > 23:59,         d < 0
     * <p>
     */

    //    1. s < 0,             d > 60
    //    6. s < 0,             0 <= d <= 60
    //   11. s < 0,             d < 0
    @Test
    @DisplayName("Calls start before 00:00 and valid duration more than 60")
    void shouldReturnMinusOne1() {
        assertEquals(-1.0, getCallCost("-00:01", 90));
        assertEquals(-1.0, getCallCost("-00:02", 90));
    }

    @Test
    @DisplayName("Calls start before 00:00 and valid duration equals or less than 60")
    void shouldReturnMinusOne2() {
        assertEquals(-1.0, getCallCost("-00:01", 40));
        assertEquals(-1.0, getCallCost("-00:02", 40));

        // duration boundary values
        assertEquals(-1.0, getCallCost("-00:01", 0));
        assertEquals(-1.0, getCallCost("-00:01", 1));
        assertEquals(-1.0, getCallCost("-00:01", 59));
        assertEquals(-1.0, getCallCost("-00:01", 60));
    }

    @Test
    @DisplayName("Calls start before 00:00 and invalid duration")
    void shouldReturnMinusOne3() {
        assertEquals(-1.0, getCallCost("-00:01", -10));
        assertEquals(-1.0, getCallCost("-00:02", -10));
    }

    //    2. 0 <= s < 8,         d > 60
    //    7. 0 <= s < 8,         0 <= d <= 60
    //   12. 0 <= s < 8,         d < 0
    @Test
    @DisplayName("Calls start between 00:00 and 07:59 and valid duration more than 60")
    void shouldReturnCostBetweenZeroAndEight1() {
        assertEquals(20.08, getCallCost("00:00", 90));
        assertEquals(20.08, getCallCost("04:01", 90));
        assertEquals(20.08, getCallCost("07:59", 90));
    }

    @Test
    @DisplayName("Calls start between 00:00 and 07:59 and valid duration equals or less than 60")
    void shouldReturnCostBetweenZeroAndEight2() {
        assertEquals(10.5, getCallCost("00:00", 40));
        assertEquals(10.5, getCallCost("07:59", 40));
        assertEquals(10.5, getCallCost("04:01", 40));

        // duration boundary values
        assertEquals(0.0, getCallCost("04:01", 0));
        assertEquals(0.26, getCallCost("04:01", 1));
        assertEquals(15.49, getCallCost("04:01", 59));
        assertEquals(15.75, getCallCost("04:01", 60));
    }

    @Test
    @DisplayName("Calls start between 00:00 and 07:59 and invalid duration")
    void shouldReturnMinusOne4() {
        assertEquals(-1.0, getCallCost("00:00", -10));
        assertEquals(-1.0, getCallCost("04:01", -10));
        assertEquals(-1.0, getCallCost("07:59", -10));
    }

    //    3. 8 <= s < 18,        d > 60
    //    8. 8 <= s < 18,        0 <= d <= 60
    //   13. 8 <= s < 18,        d < 0
    @Test
    @DisplayName("Calls start between 08:00 and 17:59 and valid duration more than 60")
    void shouldReturnCostBetweenEightAndEighteen1() {
        assertEquals(40.16, getCallCost("08:00", 90));
        assertEquals(40.16, getCallCost("12:00", 90));
        assertEquals(40.16, getCallCost("17:59", 90));
    }

    @Test
    @DisplayName("Calls start between 08:00 and 17:59 and valid duration equals or less than 60")
    void shouldReturnCostBetweenEightAndEighteen2() {
        assertEquals(21, getCallCost("08:00", 40));
        assertEquals(21, getCallCost("17:59", 40));
        assertEquals(21, getCallCost("12:00", 40));

        // duration boundary values
        assertEquals(0.0, getCallCost("12:00", 0));
        assertEquals(0.53, getCallCost("12:00", 1));
        assertEquals(30.98, getCallCost("12:00", 59));
        assertEquals(31.5, getCallCost("12:00", 60));
    }

    @Test
    @DisplayName("Calls start between 08:00 and 17:59 and invalid duration")
    void shouldReturnMinusOne5() {
        assertEquals(-1.0, getCallCost("08:00", -10));
        assertEquals(-1.0, getCallCost("12:00", -10));
        assertEquals(-1.0, getCallCost("17:59", -10));
    }

    //    4. 18 <= s <= 23:59,    d > 60
    //    9. 18 <= s <= 23:59,    0 <= d <= 60
    //   14. 18 <= s <= 23:59,    d < 0
    @Test
    @DisplayName("Calls start between 18:00 and 23:59 and valid duration more than 60")
    void shouldReturnCostBetweenEighteenAndTwentyFour1() {
        assertEquals(20.08, getCallCost("18:00", 90));
        assertEquals(20.08, getCallCost("21:00", 90));
        assertEquals(20.08, getCallCost("23:59", 90));
    }

    @Test
    @DisplayName("Calls start between 18:00 and 23:59 and valid duration equals or less than 60")
    void shouldReturnCostBetweenEighteenAndTwentyFour2() {
        assertEquals(10.5, getCallCost("18:00", 40));
        assertEquals(10.5, getCallCost("23:59", 40));
        assertEquals(10.5, getCallCost("21:00", 40));

        // duration boundary values
        assertEquals(0.0, getCallCost("21:00", 0));
        assertEquals(0.26, getCallCost("21:00", 1));
        assertEquals(15.49, getCallCost("21:00", 59));
        assertEquals(15.75, getCallCost("21:00", 60));
    }

    @Test
    @DisplayName("Calls start between 18:00 and 23:59 and invalid duration")
    void shouldReturnMinusOne6() {
        assertEquals(-1.0, getCallCost("18:00", -10));
        assertEquals(-1.0, getCallCost("21:00", -10));
        assertEquals(-1.0, getCallCost("23:59", -10));
    }

    //    5. s > 23:59,         d > 60
    //   10. s > 23:59,         0 <= d <= 60
    //   15. s > 23:59,         d < 0
    @Test
    @DisplayName("Calls start after 23:59 and valid duration more than 60")
    void shouldReturnMinusOne7() {
        assertEquals(-1.0, getCallCost("24:00", 90));
        assertEquals(-1.0, getCallCost("24:01", 90));
    }

    @Test
    @DisplayName("Calls start after 23:59 and valid duration equals or less than 60")
    void shouldReturnMinusOne8() {
        assertEquals(-1.0, getCallCost("24:00", 40));
        assertEquals(-1.0, getCallCost("24:01", 40));

        // duration boundary values
        assertEquals(-1.0, getCallCost("24:00", 0));
        assertEquals(-1.0, getCallCost("24:00", 1));
        assertEquals(-1.0, getCallCost("24:00", 59));
        assertEquals(-1.0, getCallCost("24:00", 60));
    }

    @Test
    @DisplayName("Calls start after 23:59 and invalid duration")
    void shouldReturnMinusOne9() {
        assertEquals(-1.0, getCallCost("24:00", -10));
        assertEquals(-1.0, getCallCost("24:01", -10));
    }

    //    invalid input format
    @Test
    @DisplayName("Calls start with invalid inputs format")
    void shouldReturnMinusOne10() {
        assertEquals(-1.0, getCallCost("24::0", 1));
        assertEquals(-1.0, getCallCost("2::01", 59));
        assertEquals(-1.0, getCallCost(":::::", 61));
    }
}
