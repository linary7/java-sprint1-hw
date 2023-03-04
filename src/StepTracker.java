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
        System.out.println("Введите номер месяца:");
        int a = scanner.nextInt();
        if (a < 1) {
            System.out.println("Такого месяца нет");
            return;
        } else if (a > 12) {
            System.out.println("Такого месяца нет");
            return;
        }

        System.out.println("Введите номер дня (от 1 до 30 включительно):");
        int b = scanner.nextInt();
        if (b < 1) {
            System.out.println("Такого дня нет");
            return;
        } else if (b > 30) {
            System.out.println("Такого дня нет");
            return;
        }

        System.out.println("Введите количество шагов:");
        int c = scanner.nextInt();
        if (c < 0) {
            System.out.println("Количество шагов не может быть отрицательным");
            return;
        }
        MonthData monthData = monthToData[a-1];
        monthData.days[b-1] = c;
    }
    void changeStepGoal() {
        System.out.println("Введите новую цель по количеству шагов в день:");
        int i = scanner.nextInt();
        if (i < 1) {
            System.out.println("Цель по количеству шагов должна быть больше нуля!");
            return;
        }
        goalByStepsPerDay = i;
        System.out.println(goalByStepsPerDay);
    }
    void printStatistic() {
        System.out.println("Введите номер месяца:");
        int i = scanner.nextInt();
        if (i < 1) {
            System.out.println("Такого месяца нет");
            return;
        } else if (i > 12) {
            System.out.println("Такого месяца нет");
            return;
        }

        MonthData monthData = monthToData[i - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsByMonth();
        System.out.println("Вы прошли " + sumSteps + " шагов");
        System.out.println("Самое большое количество шагов, пройденных за день: " + monthData.maxSteps());
        System.out.println("В среднем вы проходили " + sumSteps/30 + " шагов в день");
        System.out.println("За месяц вы прошли " + converter.convertToKm(sumSteps) + " километров");
        System.out.println("За месяц вы сожгли " + converter.convertStepsToKilocalories(sumSteps) + " килокалорий");
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
