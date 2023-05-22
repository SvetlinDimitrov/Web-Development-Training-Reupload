package JavaAdvance.Exercises_Defining_Classes.Google_07;

import org.w3c.dom.xpath.XPathResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String [] input;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine().split(" ");
        List<Person> setPeoples = new ArrayList<>();

        while(!input[0].equals("End")){
            boolean isTheNameHere = setPeoples.stream().anyMatch(e-> e.getPersonName().equals(input[0]));
            if(!isTheNameHere){
                setPeoples.add(new Person(input[0]));
            }

                switch (input[1]){
                    case"company":
                        setPeoples.get(RightIndex(setPeoples,input[0]))
                                .setCompany(new Company(input[2],input[3],Double.parseDouble(input[4])));
                        break;
                    case "pokemon":
                        setPeoples.get(RightIndex(setPeoples,input[0]))
                                .setPokemonList(new Pokemon(input[2] , input[3]));
                        break;
                    case "parents":
                        setPeoples.get(RightIndex(setPeoples,input[0]))
                                .setParentsList(new Parents(input[2],input[3]));
                        break;
                    case"children":
                        setPeoples.get(RightIndex(setPeoples,input[0]))
                                .setChildrenList(new Children(input[2] , input[3]));
                        break;
                    case "car":
                        setPeoples.get(RightIndex(setPeoples,input[0]))
                                .setCar(new Car(input[2],Integer.parseInt(input[3])));
            }

            input = scanner.nextLine().split(" ");
        }
        input = scanner.nextLine().split(" ");
        setPeoples.stream().filter(person -> person.getPersonName().equals(input[0]))
                .forEach(person -> {
                    System.out.printf("%s%n",person.getPersonName());
                    System.out.printf("Company:%n");
                    if (person.getCompany() != null) {
                        System.out.printf("%s %s %.2f%n",
                                person.getCompany().getCompanyName(),
                                person.getCompany().getDepartment(),
                                person.getCompany().getSalary());
                    }
                    System.out.printf("Car:%n");
                    if(person.getCar() !=null){
                        System.out.printf("%s %d%n",
                                person.getCar().getCarName(),
                                person.getCar().getCarSpeed());
                    }
                    System.out.printf("Pokemon:%n");
                    if(person.getPokemonList() !=null){
                        person.getPokemonList().stream().forEach(pokemon -> {
                            System.out.printf("%s %s%n",pokemon.getPokemonName() , pokemon.getPokemonType());
                        });
                    }System.out.printf("Parents:%n");
                    if(person.getParentsList() != null){
                        person.getParentsList().stream().forEach(parents -> {
                            System.out.printf("%s %s%n",parents.getParentName(),parents.getParentBirthDay());
                        });
                    }
                    System.out.printf("Children:%n");
                    if(person.getChildrenList() !=null){
                        person.getChildrenList().stream().forEach(children -> {
                            System.out.printf("%s %s%n",children.getChildrenName() , children.getChildrenBirthday());
                        });
                    }
                });
    }

    private static int RightIndex(List<Person> setPeoples, String s) {
        for (int i = 0; i < setPeoples.size(); i++) {
            if(setPeoples.get(i).getPersonName().equals(s)){
                return i;
            }
        }
        return  -1;
    }
}
