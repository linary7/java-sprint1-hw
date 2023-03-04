public class MonthData {
  int[] days = new int[30];

  void printDaysAndStepsByMonth() {
    for (int i = 0; i < days.length; i++) {
      System.out.println("День " + (i + 1) + ": " + days[i]);
    }
  }
  int sumStepsFromMonth() {
    int sumSteps = 0;
    for (int i = 0; i < days.length; i++) {
      sumSteps = sumSteps + days[i];
    }
    return sumSteps;
  }
  int maxSteps() {
    int maxSteps = 0;
    for (int i = 0; i < days.length; i++) {
      while (maxSteps < days[i]) {
        maxSteps = days[i];
      }
    }
    return maxSteps;
  }
  int bestSeries (int goalByStepsPerDay) {
    int currentSeries = 0;
    int finalSeries = 0;
    for (int i = 0; i < days.length; i++) {
      if (days[i] >= goalByStepsPerDay) {
        currentSeries++;
        if (finalSeries < currentSeries) {
          finalSeries = currentSeries;
        }
      } else {
        break;
      }
    } return finalSeries;
  }
}
