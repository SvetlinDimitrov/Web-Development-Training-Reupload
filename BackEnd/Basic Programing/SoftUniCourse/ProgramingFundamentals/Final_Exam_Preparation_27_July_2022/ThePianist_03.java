package ProgramingFundamentalsJava.Final_Exam_Preparation_27_July_2022;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Map<String , String> mainMap = new LinkedHashMap<>();
        Map<String , String > map = new LinkedHashMap<>();

        for (int i = 0; i <times ; i++) {
            //"{piece}|{composer}|{key}".
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];
            mainMap.put(piece , composer);
            map.put(piece , key);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")){
            //"Add|{piece}|{composer}|{key}":
            String command = input.split("\\|")[0];

            if(command.equals("Add")) {
                String piece = input.split("\\|")[1];
                String composer = input.split("\\|")[2];
                String key = input.split("\\|")[3];
                if(!mainMap.containsKey(piece)) {
                    mainMap.put(piece , composer);
                    map.put(piece , key);
                    System.out.printf("%s by %s in %s added to the collection!%n",piece,composer , key);
                }else{
                    System.out.printf("%s is already in the collection!%n",piece);
                }
            }else if ( command.equals("Remove")){
                String piece = input.split("\\|")[1];
                if(mainMap.containsKey(piece)){
                    mainMap.remove(piece);
                    map.remove(piece);
                    System.out.printf("Successfully removed %s!%n",piece);
                }else{
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                }
            }else if (command.equals("ChangeKey")){
                String piece = input.split("\\|")[1];
                String key = input.split("\\|")[2];
                if(mainMap.containsKey(piece)){
                    map.put(piece , key);
                    System.out.printf("Changed the key of %s to %s!%n",piece,key);
                }else{
                    System.out.printf("Invalid operation! %s does not exist in the collection.",piece);
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String , String > entryMain :mainMap.entrySet()){
            for(Map.Entry<String , String> entry : map.entrySet()){
                if(entryMain.getKey().equals(entry.getKey())){
                    System.out.printf("%s -> Composer: %s, Key: %s%n",entryMain.getKey(),entryMain.getValue(),entry.getValue());
                }
            }
        }
    }
}
