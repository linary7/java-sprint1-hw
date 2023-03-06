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
        int monthIndex = requestMonth();
        if (monthIndex == 0) {
            System.out.println("Такого месяца нет");
            return;
        }

        System.out.println("Введите номер дня (от 1 до 30 включительно):");
        int dayIndex = scanner.nextInt();
        if (dayIndex < 1) {
            System.out.println("Такого дня нет");
            return;
        } else if (dayIndex > 30) {
            System.out.println("Такого дня нет");
            return;
        }

        System.out.println("Введите количество шагов:");
        int stepAmount = scanner.nextInt();
        if (stepAmount < 0) {
            System.out.println("Количество шагов не может быть отрицательным");
            return;
        }
        MonthData monthData = monthToData[monthIndex - 1];
        monthData.days[dayIndex - 1] = stepAmount;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель по количеству шагов в день:");
        int stepGoal = scanner.nextInt();
        if (stepGoal < 1) {
            System.out.println("Цель по количеству шагов должна быть больше нуля!");
            return;
        }
        goalByStepsPerDay = stepGoal;
        System.out.println(goalByStepsPerDay);
    }

    void printStatistic() {
        int monthIndex = requestMonth();
        if (monthIndex == 0) {
            System.out.println("Такого месяца нет");
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

    int requestMonth () {
        System.out.println("Введите номер месяца:");
        int monthIndex = scanner.nextInt();
        if (monthIndex < 1) {
            return 0;
        } else if (monthIndex > 12) {
            return 0;
        } else {
            return monthIndex;
        }
    }
}
