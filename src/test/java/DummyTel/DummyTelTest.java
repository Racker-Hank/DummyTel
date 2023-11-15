package DummyTel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static DummyTel.DummyTel.getCallCost;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DummyTelTest {

    /**
     * 2 inputs: Start time (s) and Duration (d)
     */

    @Test
    @DisplayName("Call start from 23:45 and duration (positive) less than 60")
    void shouldReturnHalfCost1() {
        assertEquals(10.5, getCallCost("23:45", 40));
    }

    @Test
    @DisplayName("Call start from 23:45 and duration (positive) more than 60")
    void shouldReturnHalfCost2() {
        assertEquals(22.31, getCallCost("23:45", 100));
    }

    @Test
    @DisplayName("Call start from 23:45 and duration lesser or equal to 0")
    void shouldReturnMinusOne1() {
        assertEquals(-1.0, getCallCost("23:45", -10));
    }

    @Test
    @DisplayName("Call start from 15:00 and duration (positive) less than 60")
    void shouldReturnFullCost1() {
        assertEquals(21.0, getCallCost("15:00", 40));
    }

    @Test
    @DisplayName("Call start from 15:00 and duration (positive) more than 60")
    void shouldReturnFullCost2() {
        assertEquals(39.27, getCallCost("15:00", 88));
    }

    @Test
    @DisplayName("Call start from 15:00 and duration lesser or equal to 0")
    void shouldReturnMinusOne2() {
        assertEquals(-1.0, getCallCost("15:00", -10));
    }

    @Test
    @DisplayName("Call start from -00:01 and duration (positive) less than 60")
    void shouldReturnMinusOne3() {
        assertEquals(-1.0, getCallCost("-00:01", 40));
    }

    @Test
    @DisplayName("Call start from -00:01 and duration (positive) more than 60")
    void shouldReturnMinusOne4() {
        assertEquals(-1.0, getCallCost("-00:01", 88));
    }

    @Test
    @DisplayName("Call start from -00:01 and duration lesser or equal to 0")
    void shouldReturnMinusOne5() {
        assertEquals(-1.0, getCallCost("-00:01", 40));
    }

    @Test
    @DisplayName("Call start from 24:01 and duration (positive) less than 60")
    void shouldReturnMinusOne6() {
        assertEquals(-1.0, getCallCost("24:01", 40));
    }

    @Test
    @DisplayName("Call start from 24:01 and duration (positive) more than 60")
    void shouldReturnMinusOne7() {
        assertEquals(-1.0, getCallCost("24:01", 88));
    }

    @Test
    @DisplayName("Call start from 24:01 and duration lesser or equal to 0")
    void shouldReturnMinusOne8() {
        assertEquals(-1.0, getCallCost("24:01", -10));
    }

    @Test
    @DisplayName("Call start from 08:00, 08:01, 17:59, 23:59 and valid duration")
    void shouldReturnFullCostBetweenEightAndEighteen1() {
        assertEquals(30.98, getCallCost("08:00", 59));
        assertEquals(30.98, getCallCost("08:01", 59));
        assertEquals(30.98, getCallCost("17:59", 59));
        assertEquals(31.50, getCallCost("08:00", 60));
        assertEquals(31.50, getCallCost("08:01", 60));
        assertEquals(31.50, getCallCost("17:59", 60));
        assertEquals(27.22, getCallCost("08:00", 61));
        assertEquals(27.22, getCallCost("08:01", 61));
        assertEquals(27.22, getCallCost("17:59", 61));
        assertEquals(0.53, getCallCost("08:00", 1));
        assertEquals(0.53, getCallCost("08:01", 1));
        assertEquals(0.53, getCallCost("17:59", 1));
        assertEquals(0.0, getCallCost("08:00", 0));
        assertEquals(0.0, getCallCost("08:01", 0));
        assertEquals(0.0, getCallCost("17:59", 0));
    }

    @Test
    @DisplayName("Call start from 08:00, 17:59, 23:59 and invalid duration")
    void shouldReturnMinusOne9() {
        assertEquals(-1.0, getCallCost("08:00", -1));
        assertEquals(-1.0, getCallCost("08:01", -1));
        assertEquals(-1.0, getCallCost("17:59", -1));
        assertEquals(-1.0, getCallCost("00:00", -1));
    }

    @Test
    @DisplayName("Call start from 00:00, 00:01, 07:59, 18:00, 18:01 and valid duration")
    void shouldReturnHalfCostBetweenEighteenAndEight1() {
        assertEquals(0.0, getCallCost("00:00", 0));
        assertEquals(0.0, getCallCost("00:01", 0));
        assertEquals(0.0, getCallCost("07:59", 0));
        assertEquals(0.0, getCallCost("18:00", 0));
        assertEquals(0.0, getCallCost("18:01", 0));
        assertEquals(0.0, getCallCost("23:59", 0));
        assertEquals(11.81, getCallCost("00:00", 45));
        assertEquals(11.81, getCallCost("00:01", 45));
        assertEquals(11.81, getCallCost("07:59", 45));
        assertEquals(11.81, getCallCost("18:00", 45));
        assertEquals(11.81, getCallCost("18:01", 45));
        assertEquals(11.81, getCallCost("23:59", 45));
        assertEquals(7.88, getCallCost("00:00", 30));
        assertEquals(7.88, getCallCost("00:01", 30));
        assertEquals(7.88, getCallCost("07:59", 30));
        assertEquals(7.88, getCallCost("18:00", 30));
        assertEquals(7.88, getCallCost("18:01", 30));
        assertEquals(7.88, getCallCost("23:59", 30));
        assertEquals(13.39, getCallCost("00:00", 51));
        assertEquals(13.39, getCallCost("00:01", 51));
        assertEquals(13.39, getCallCost("07:59", 51));
        assertEquals(13.39, getCallCost("18:00", 51));
        assertEquals(13.39, getCallCost("18:01", 51));
        assertEquals(13.39, getCallCost("23:59", 51));
        assertEquals(19.19, getCallCost("00:00", 86));
        assertEquals(19.19, getCallCost("00:01", 86));
        assertEquals(19.19, getCallCost("07:59", 86));
        assertEquals(19.19, getCallCost("18:00", 86));
        assertEquals(19.19, getCallCost("18:01", 86));
        assertEquals(19.19, getCallCost("23:59", 86));
    }

    @Test
    @DisplayName("Call start from 07:59, 18:00 and invalid duration")
    void shouldReturnMinusOne10() {
        assertEquals(-1.0, getCallCost("00:00", -1));
        assertEquals(-1.0, getCallCost("00:01", -1));
        assertEquals(-1.0, getCallCost("07:59", -1));
        assertEquals(-1.0, getCallCost("18:00", -1));
        assertEquals(-1.0, getCallCost("18:01", -1));
        assertEquals(-1.0, getCallCost("23:59", -1));
    }

    @Test
    @DisplayName("Call start from 24:00, 24:01, -00:01 and valid duration")
    void shouldReturnMinusOne11() {
        assertEquals(-1.0, getCallCost("24:00", 0));
        assertEquals(-1.0, getCallCost("24:01", 0));
        assertEquals(-1.0, getCallCost("-00:01", 0));
        assertEquals(-1.0, getCallCost("24:00", 1));
        assertEquals(-1.0, getCallCost("24:01", 1));
        assertEquals(-1.0, getCallCost("-00:01", 1));
        assertEquals(-1.0, getCallCost("24:00", 59));
        assertEquals(-1.0, getCallCost("24:01", 59));
        assertEquals(-1.0, getCallCost("-00:01", 59));
        assertEquals(-1.0, getCallCost("24:00", 60));
        assertEquals(-1.0, getCallCost("24:01", 60));
        assertEquals(-1.0, getCallCost("-00:01", 60));
        assertEquals(-1.0, getCallCost("24:00", 61));
        assertEquals(-1.0, getCallCost("24:01", 61));
        assertEquals(-1.0, getCallCost("-00:01", 61));
    }

    @Test
    @DisplayName("Call start from 24:00, 24:01, -00:01 and invalid duration")
    void shouldReturnMinusOne12() {
        assertEquals(-1.0, getCallCost("24:00", -1));
        assertEquals(-1.0, getCallCost("24:01", -1));
        assertEquals(-1.0, getCallCost("-00:01", -1));
    }

    @Test
    @DisplayName("Call start with invalid inputs format")
    void shouldReturnMinusOne13() {
        assertEquals(-1.0, getCallCost("24::0", 1));
        assertEquals(-1.0, getCallCost("2::01", 59));
        assertEquals(-1.0, getCallCost(":::::", 61));
    }
}