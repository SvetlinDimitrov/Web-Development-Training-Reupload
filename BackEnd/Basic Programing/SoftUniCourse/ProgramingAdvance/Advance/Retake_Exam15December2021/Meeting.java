package JavaAdvance.Exams.Java_Advanced_Retake_Exam15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> male = new ArrayDeque<>();
        ArrayDeque<Integer> female = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(e->e>0)
                .forEach(male::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(e->e>0)
                .forEach(female::offerLast);
        int matches =0;
        while(!male.isEmpty() && !female.isEmpty()){
            int maleNum = male.pop();
            int femaleNum = female.pollFirst();

            if(maleNum == femaleNum){
                matches++;
            }else{
                maleNum-=2;
                if(maleNum >0){
                    male.push(maleNum);
                }
            }
        }
        System.out.printf("Matches: %d%n",matches);
        if(male.isEmpty()){
           System.out.println("Males left: none");
        }else {
            System.out.printf("Males left: %s%n",
                    male.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if(female.isEmpty()){
            System.out.println("Females left: none");
        }else{
            System.out.printf("Females left: %s%n",
                    female.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
