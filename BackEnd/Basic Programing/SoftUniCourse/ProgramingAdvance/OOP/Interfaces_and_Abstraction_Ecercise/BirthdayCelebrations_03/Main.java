import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String toPrint;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> list = new ArrayList<>();
        String [] arr = scanner.nextLine().split(" ");

        while(!arr[0].equals("End")){
            if(arr.length == 5){
                list.add(new Citizen(arr[1] , Integer.parseInt(arr[2]) , arr[3] , arr[4]));
            }else if (arr.length == 3 && arr[0].equals("Pet")){
                list.add(new Pet(arr[1] , arr[2]));
            }
            arr = scanner.nextLine().split(" ");
        }
        toPrint = scanner.nextLine();
        StringBuilder print = new StringBuilder();
        list.stream().map(Birthable::getBirthDate)
                .filter(e-> e.substring(e.length()-4 , e.length()).equals(toPrint))
                .forEach(e->print.append(String.format("%s%n",e)));
        if(print.length() == 0){
            System.out.println("<no output>");
        }else{
            System.out.println(print.toString());
        }
    }
}
