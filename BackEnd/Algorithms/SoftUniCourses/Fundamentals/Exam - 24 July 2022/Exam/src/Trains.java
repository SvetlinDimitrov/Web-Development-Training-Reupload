import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Trains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrival = scanner.nextLine().split(" ");
        String[] departure = scanner.nextLine().split(" ");

        Change(arrival);
        Change(departure);

        boolean [] platforms = new boolean[arrival.length];
        platforms[0] = true;

        for (int i = 1; i < arrival.length; i++) {
            LocalTime currentTrain = LocalTime.parse(arrival[i]);
            LocalTime pastTrain = LocalTime.parse(arrival[i-1]);
            LocalTime pastTrainGoes = LocalTime.parse(departure[i-1]);

            if(currentTrain.isAfter(pastTrain) && currentTrain.isBefore(pastTrainGoes)){
                platforms[i] = true;
                continue;
            }
            platforms[i] = false;

        }
        int count = 0;
        for (int i = 0; i < platforms.length; i++) {
            if(!platforms[i]){
                count++;
            }
        }

        System.out.println(count);
    }

    private static void Change (String[] arrival) {
        for (int i = 0; i < arrival.length; i++) {
            int count = 0;
            for (int j = 0; j < arrival[i].length(); j++) {
                if (arrival[i].charAt(j) != '.'){
                    count++;
                    continue;
                }
                break;
            }
            if(count != 2){
                arrival[i] = String.format("0" + arrival[i]);
            }
            arrival[i] = arrival[i].replace('.' , ':');
        }
    }

    private static boolean isaBoolean(double arrival) {
        return Double.compare(arrival, 00.00) >= 0 && Double.compare(arrival, 00.59) <= 0;
    }
}
