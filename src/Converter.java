public class Converter {
    private static final double STEP_KILOMETER_LENGTH = 0.00075;
    private static final int STEP_CALORIE_AMOUNT = 50;
    private static final double CALORIE_IN_KILOCALORIES = 0.001;

    int convertToKm(int steps){
       return (int) (steps * STEP_KILOMETER_LENGTH);
    }

    int convertStepsToKilocalories(int steps) {
        return (int) ((steps * STEP_CALORIE_AMOUNT) * CALORIE_IN_KILOCALORIES);
    }
}
