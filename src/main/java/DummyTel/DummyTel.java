package DummyTel;

public class DummyTel {

    /**
     * 1. All calls starting from 18:00 onwards but before 08:00 will get 50% discount
     * 2. All calls starting from 08:00 onwards but before 18:00 will be at full price
     * 3. All calls will be taxed at 5%
     * 4. Cost for each minute is 0.5 dong
     * 5. All calls that has duration more than 60 minutes will get 15% discount (off the deducted cost but before tax)
     *
     * @param startTime starting time of the call, in format HH:mm
     * @param duration  duration of the call in minutes
     * @return total cost of the call
     */
    public static Double getCallCost(String startTime, long duration) {
        if (startTime.length() != 5 || duration < 0) {
            return -1.0;
        }

        double cost;
        int hour, minute;

        try {
            hour = Integer.parseInt(startTime.substring(0, 2));
            minute = Integer.parseInt(startTime.substring(3, 5));
        } catch (NumberFormatException e) {
            return -1.0;
        }

        if ((hour == 23 && minute >= 60) || hour >= 24) {
            return -1.0;
        }

        double NON_WORK_HOUR_DISCOUNT = (double) 50 / 100;
        double TAX = (double) 5 / 100;
        double CALL_COST_PER_MIN = 0.5;
        double LONGER_THAN_60_MIN_DISCOUNT = (double) 15 / 100;

        cost = duration * CALL_COST_PER_MIN;
        if (hour < 8 || hour >= 18) {
            cost *= (1 - NON_WORK_HOUR_DISCOUNT);
        }
        if (duration > 60) {
            cost *= (1 - LONGER_THAN_60_MIN_DISCOUNT);
        }
        cost *= (1 + TAX);

        return Double.parseDouble(String.format("%.2f", cost));
    }

}
