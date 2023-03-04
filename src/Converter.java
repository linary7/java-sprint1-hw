public class Converter {
    int convertToKm(int steps){
       double km = steps * 0.00075;
       int kmRounded = (int) km;
       return kmRounded;
    }

    int convertStepsToKilocalories(int steps) {
        int  cal = steps * 50;
        double kilocal = cal * 0.001;
        int kilocalRounded = (int) kilocal;
        return kilocalRounded;
    }
}
