package JavaAdvance.Exercises_Defining_Classes.Pokemon_Trainer_06;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static boolean hasElement;
    public static int index;
    public static String [] input;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Trainer> trainerList = new ArrayList<>();
        List<Integer> toDelete = new ArrayList<>();

        input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("Tournament")){

            boolean anyMatch = trainerList.stream().anyMatch(e-> e.getName().equals(input[0]));
            if(!anyMatch){
                trainerList.add(new Trainer(input[0]));
                index = IndexOf(trainerList , input[0]);
                trainerList.get(index).addPokemon(new Pokemon(input[1], input[2],Integer.parseInt(input[3])));
            }else{
                index = IndexOf(trainerList , input[0]);
                trainerList.get(index).addPokemon(new Pokemon(input[1], input[2],Integer.parseInt(input[3])));
            }

            input = scanner.nextLine().split(" ");
        }

        input = scanner.nextLine().split(" ");
        while(!input[0].equals("End")){
            for (int i = 0; i < trainerList.size(); i++) {
                hasElement = trainerList.get(i).getCollection()
                        .stream().anyMatch(pokemon -> pokemon.getElement().equals(input[0]));
                if(hasElement){
                    trainerList.get(i).setBadges(1);
                }else{
                    for (int j = 0; j < trainerList.get(i).getCollection().size(); j++) {
                        trainerList.get(i).getCollection().get(j).loseHp(10);
                        if(trainerList.get(i).getCollection().get(j).getHp() <=0){
                            trainerList.get(i).getCollection().remove(j);
                            j--;
                        }
                    }
                }

            }
            input = scanner.nextLine().split(" ");
        }
        trainerList.stream().sorted((trainer1 , trainer2) -> Integer.compare(trainer2.getBadges() , trainer1.getBadges()))
                .forEach(trainer -> System.out.printf("%s %d %d%n",trainer.getName()
        ,trainer.getBadges(),trainer.getCollection().size()));

    }
    public static int IndexOf(List<Trainer> list , String name){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
