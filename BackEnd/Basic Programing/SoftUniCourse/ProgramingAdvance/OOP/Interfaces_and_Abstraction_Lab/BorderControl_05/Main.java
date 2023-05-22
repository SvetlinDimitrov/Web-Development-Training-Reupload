import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] arr = scanner.nextLine().split(" ");
        List<Identifiable> list = new ArrayList<>();
        while (!arr[0] .equals("End")){
            if(arr.length == 3){
                Citizen person = new Citizen(arr[0] , Integer.parseInt(arr[1]), arr[2]);
                list.add(person);
            }else if (arr.length == 2){
                Robot robot = new Robot(arr[0] , arr[1]);
                list.add(robot);
            }
            arr = scanner.nextLine().split(" ");
        }
        String match = scanner.nextLine();
        list.stream().map(Identifiable::getId)
                .filter(e->{
                    for (int i = 0; i < match.length(); i++) {
                       if(e.charAt(e.length()-1-i) != match.charAt(match.length()-1-i)){
                           return false;
                       }
                    }
                    return true;
                })
                .forEach(System.out::println);
    }
}
