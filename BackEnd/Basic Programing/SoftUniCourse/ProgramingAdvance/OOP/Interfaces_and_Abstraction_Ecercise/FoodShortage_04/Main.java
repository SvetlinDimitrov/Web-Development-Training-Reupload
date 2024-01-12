
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        List<Buyer> list = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            String [] arr = scanner.nextLine().split(" ");
            if(arr.length == 4){
                list.add(new Citizen(arr[0] , Integer.parseInt(arr[1]),arr[2],arr[3]));
            }else if (arr.length == 3){
                list.add(new Rebel(arr[0] , Integer.parseInt(arr[1]),arr[2]));
            }
        }
        int sum = 0;
        String name = scanner.nextLine();
        while(!name.equals("End")){
            for (Buyer buyer : list) {
                if(buyer.getName().equals(name)){
                    sum+=buyer.getFood();
                }
            }
            name = scanner.nextLine();

        }
        System.out.println(sum);
    }
}
