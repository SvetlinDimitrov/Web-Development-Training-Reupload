package JavaAdvance.Exercises_Generics.Custom_List_Sorter_08;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Glist<String>list = new Glist<>();

        String input = scanner.nextLine();
        while(!input.equals("END")){
            String command = input.split(" ")[0];
            switch (command){
                case "Add":
                    String add = input.split(" ")[1];
                    list.add(add);
                    break;
                case "Remove":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    if(index <= list.getSize() && index >=0){
                        list.remove(index);
                    }
                    break;
                case "Contains":
                    String check = input.split(" ")[1];
                    System.out.println(list.contains(check));
                    break;
                case "Swap":
                    int swap1 =Integer.parseInt(input.split(" ")[1]);
                    int swap2 =Integer.parseInt(input.split(" ")[2]);
                    if(swap1 <= list.getSize() && swap1 >= 0 && swap2 <= list.getSize() && swap2>=0 ) {
                        list.swap(swap1, swap2);
                    }
                    break;
                case"Greater":
                    String greater = input.split(" ")[1];
                    System.out.println(list.countGreaterThen(greater));
                    break;

                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.print(list);
                    break;
                case "Sort":
                    list.sort();
            }
            input = scanner.nextLine();
        }
    }
}
