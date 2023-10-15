import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Knapsack {
    public  static  class Item{
        String name;
        int capacity;
        int value;

        public Item(String name, int capacity, int value) {
            this.name = name;
            this.capacity = capacity;
            this.value = value;
        }
    }
    static List<Item>list;
    static int [][] memo;
    static String[][]memoNames;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        list= new ArrayList<>();
        String input = scanner.nextLine();
        while(!input.equals("end")){
            String currentName = input.split(" ")[0];
            int currentItemCapacity = Integer.parseInt(input.split(" ")[1]);
            int currentItemValue = Integer.parseInt(input.split(" ")[2]);
            input = scanner.nextLine();
            if(currentItemCapacity > capacity){continue;}
            list.add(new Item(currentName,currentItemCapacity,currentItemValue));
        }
        memoNames = new String[list.size()+1][capacity+1];
        Arrays.fill(memoNames[0] ,"");
        memo = new int [list.size()+1][capacity+1];
        for (int i = 1; i < memo.length; i++) {
            Arrays.fill(memoNames[i] ,"");
            for (int j = 0; j < memo[i].length; j++) {

                int currentItemCap = list.get(i-1).capacity;
                int currentItemValue = list.get(i-1).value;
                if(j >= currentItemCap){
                    int currentValue = currentItemValue + memo[i-1][j-currentItemCap];
                    int secondValue = memo[i-1][j];

                    if(currentValue > secondValue){
                        memoNames[i][j] = String.format("%s %s",list.get(i-1).name,memoNames[i-1][j-currentItemCap]);
                        memo[i][j] = currentValue;
                    }else{
                        memo[i][j] = secondValue;
                        memoNames[i][j] = memoNames[i-1][j];
                    }

                }
            }
        }
        System.out.println(memo[list.size()][capacity]);
    }
}
