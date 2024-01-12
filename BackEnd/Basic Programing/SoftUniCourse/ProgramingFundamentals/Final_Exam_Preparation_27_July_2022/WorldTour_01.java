package ProgramingFundamentalsJava.Final_Exam_Preparation_27_July_2022;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder wordTrip = new StringBuilder();
        String firstWord = scanner.nextLine();
        wordTrip.append(firstWord);
        String input = scanner.nextLine();

        while(!input.equals("Travel")){
            if(input.contains("Add")){
                //"Add Stop:{index}:{string}":
                int index = Integer.parseInt(input.split(":")[1]);
                String thingToAdd = input.split(":")[2];
                if(isIndexValide(index , wordTrip.toString())){
                    wordTrip.insert(index , thingToAdd);
                }
            }else if (input.contains("Remove")){
                //"Remove Stop:{start_index}:{end_index}":
                int indexStart = Integer.parseInt(input.split(":")[1]);
                int indexEnd = Integer.parseInt(input.split(":")[2]);
                if(isIndexValide(indexStart , wordTrip.toString()) && isIndexValide(indexEnd , wordTrip.toString())){
                    wordTrip.delete(indexStart , indexEnd+1);
                }
            }else if (input.contains("Switch")){
                //"Switch:{old_string}:{new_string}":
                String oldString = input.split(":")[1];
                String newString = input.split(":")[2];
                if (wordTrip.toString().contains(oldString)){
                    String newWord = wordTrip.toString().replaceAll(oldString , newString);
                    wordTrip.delete(0,wordTrip.length());
                    wordTrip.append(newWord);
                }
            }


            System.out.println(wordTrip.toString());
            input = scanner.nextLine();
        }
        System.out.print("Ready for world tour! Planned stops: ");
        System.out.printf("%s",wordTrip.toString());
    }

    private static boolean isIndexValide(int index, String input) {
        if(index >= 0 && index<=input.length()-1){
            return true;
        }
        return false;
    }
}
