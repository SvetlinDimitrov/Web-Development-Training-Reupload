package JavaAdvance.Exercises_Iterators_and_Comparators.Froggy_04;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while(!input.equals("END")){
            Froggy frog = new Froggy(Arrays.stream(input.split(", ")).map(Integer::parseInt).toArray(Integer[]::new));
            Iterator<Integer> frogCopy= frog.iterator();
            StringBuilder toPrint = new StringBuilder();
            while(frogCopy.hasNext()){
                toPrint.append(String.format("%d ",frogCopy.next()));
            }
            String [] words = toPrint.toString().split(" ");
            System.out.println(String.join(", ",words));
            input = scanner.nextLine();
        }
    }
}
