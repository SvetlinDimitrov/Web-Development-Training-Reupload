package JavaAdvance.Exercises_Iterators_and_Comparators.Collection_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListyIterator list = new ListyIterator();
        while(!input.equals("END")){
            if(input.contains("Create")){
                for (int i = 1; i < input.split(" ").length; i++) {
                    list.add(input.split(" ")[i]);
                }
            }else if (input.contains("HasNext")){
                System.out.println(list.hasNext());
            }else if (input.equals("Move")){
                System.out.println(list.move());
            }else if (input.equals("Print")){
                try {
                    list.print();
                }catch (IllegalArgumentException e){
                    System.out.println("Invalid Operation!");
                }
            }else if (input.equals("PrintAll")){
                list.printAll();
            }

            input = scanner.nextLine();
        }
    }
}
