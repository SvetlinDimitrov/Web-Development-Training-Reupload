import java.util.Arrays;
import java.util.Scanner;

public class Cluster_Border {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] singleShip = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int [] pairShip = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long time = 0;

        for (int i = 1; i < singleShip.length; i++) {
            if(singleShip[i-1] + singleShip[i] < pairShip[i]){
                time +=singleShip[i];
            }else{
                time+=pairShip[i-1];
                i++;
            }
        }
        System.out.println(time);
    }
}
