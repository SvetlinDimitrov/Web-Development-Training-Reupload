package JavaAdvance.Exercises_Iterators_and_Comparators.Comparing_Objects_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> list = new ArrayList<>();


        while(!input.equals("END")){
            list.add(new Person(input.split(" ")[0], Integer.parseInt(input.split(" ")[1]), input.split(" ")[2]));
            input = scanner.nextLine();
        }
        int samePeople =0;
        int notSamePeople =0;
        int toCompare = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < list.size(); i++) {
            if(toCompare-1 != i) {
                if (list.get(toCompare - 1).compareTo(list.get(i)) == 0) {
                    samePeople++;
                } else {
                    notSamePeople++;
                }
            }
        }
        if(samePeople ==0){
            System.out.println("No matches");
        }else{
            System.out.printf("%d %d %d%n", samePeople+1 , notSamePeople , list.size());
        }
    }
}
