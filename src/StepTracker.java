import java.util.Scanner;
public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay;
    Converter converter;

    StepTracker(Scanner scan) {
        scanner = scan;
        converter = new Converter();

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        goalByStepsPerDay = 10_000;
    }

    void addNewStepsNumberPerDay() {
        int monthIndex = getMonthIndex();
        if (isInvalidMonth(monthIndex)) {
            System.out.println("Номер месяца введён неверно");
            return;
        }

        System.out.println("Введите номер дня (от 1 до 30 включительно):");
        int dayIndex = Main.scanUserInputSafely(scanner);
        if (dayIndex < 1 || dayIndex > 30) {
            System.out.println("Номер дня введён неверно");
            return;
        }

        System.out.println("Введите количество шагов:");
        int stepAmount = Main.scanUserInputSafely(scanner);
        if (stepAmount < 0) {
            System.out.println("Количество шагов введено неверно");
            return;
        }

        MonthData monthData = monthToData[monthIndex - 1];
        monthData.days[dayIndex - 1] = stepAmount;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель по количеству шагов в день:");
        int stepGoal = Main.scanUserInputSafely(scanner);
        if (stepGoal < 1) {
            System.out.println("Цель по количеству шагов должна быть больше нуля!");
            return;
        }
        goalByStepsPerDay = stepGoal;
    }

    void printStatistic() {
        int monthIndex = getMonthIndex();
        if (isInvalidMonth(monthIndex)) {
            System.out.println("Номер месяца введён неверно");
            return;
        }

        MonthData monthData = monthToData[monthIndex - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsByMonth();
        System.out.println("Вы прошли " + sumSteps + " шагов");
        System.out.println("Самое большое количество шагов, пройденных за день: " + monthData.maxSteps());
        System.out.println("В среднем вы проходили " + sumSteps / 30 + " шагов в день");
        System.out.println("За месяц вы прошли " + converter.convertToKm(sumSteps) + " километров");
        System.out.println("За месяц вы сожгли " + converter.convertStepsToKilocalories(sumSteps) + " килокалорий");
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }

    private int getMonthIndex() {
        System.out.println("Введите номер месяца от 1 до 12 включительно");
        return Main.scanUserInputSafely(scanner);
    }
    private boolean isInvalidMonth(int monthIndex) {
        return monthIndex < 1 || monthIndex > 12;
    }
}
