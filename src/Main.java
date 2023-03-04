import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewStepsNumberPerDay();
            } else if (i == 2) {
                stepTracker.changeStepGoal();
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 0) {
                System.out.println("Пока!");
                break;
            } else {
                System.out.println("Такой команды пока нет :(");
            }
        }
    }
    static void printMenu() {
        System.out.println("Доступные команды:");
        System.out.println("1 - Ввести количество шагов за какой-то день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Получить статистику за какой-то месяц");
        System.out.println("0 - Выйти");
        System.out.println("Введите номер команды:");
    }
}
