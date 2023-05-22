package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Prates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Integer> cityPopulation = new LinkedHashMap<>();
        Map<String , Integer> cityGold = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while(!input.equals("Sail")){
            String [] arr = input.split("\\|\\|");
            if(!cityPopulation.containsKey(arr[0])) {
                cityPopulation.put(arr[0], Integer.parseInt(arr[1]));
                cityGold.put(arr[0], Integer.parseInt(arr[2]));
            }else {
                int currentPopulation = cityPopulation.get(arr[0]);
                int currentGold = cityGold.get(arr[0]);
                cityPopulation.put(arr[0], currentPopulation +Integer.parseInt(arr[1]));
                cityGold.put(arr[0], currentGold+Integer.parseInt(arr[2]));
            }
            input = scanner.nextLine();
        }

        String newInput = scanner.nextLine();
        while(!newInput.equals("End")){
            String [] arr = newInput.split("=>");
            if(arr[0].equals("Plunder")){
                if(cityPopulation.containsKey(arr[1])){
                    int currentPopulation = cityPopulation.get(arr[1]);
                    int currentGold = cityGold.get(arr[1]);
                    cityPopulation.put(arr[1] ,currentPopulation-Integer.parseInt(arr[2]));
                    cityGold.put(arr[1] , currentGold - Integer.parseInt(arr[3]));
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",arr[1],Integer.parseInt(arr[3]) , Integer.parseInt(arr[2]));
                    if(cityGold.get(arr[1])<=0 || cityPopulation.get(arr[1])<=0){
                        cityGold.remove(arr[1]);
                        cityPopulation.remove(arr[1]);
                        System.out.printf("%s has been wiped off the map!%n",arr[1]);
                    }
                }
            }else if (arr[0].equals("Prosper")){
                int gold = Integer.parseInt(arr[2]);
                if(gold < 0){
                    System.out.println("Gold added cannot be a negative number!");
                }else{
                    int currentGold = cityGold.get(arr[1]);
                    cityGold.put(arr[1] , currentGold + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",gold , arr[1] , cityGold.get(arr[1]));
                }
            }
            newInput = scanner.nextLine();
        }
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cityGold.size());
        for(Map.Entry<String , Integer> populationEntry : cityPopulation.entrySet()){
            for(Map.Entry<String , Integer> goldEntry : cityGold.entrySet()){
                if(populationEntry.getKey().equals(goldEntry.getKey())){
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",populationEntry.getKey(),populationEntry.getValue(),goldEntry.getValue());
                }
            }
        }
    }
}
