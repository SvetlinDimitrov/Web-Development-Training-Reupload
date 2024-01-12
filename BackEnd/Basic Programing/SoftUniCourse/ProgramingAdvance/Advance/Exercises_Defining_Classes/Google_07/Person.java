package JavaAdvance.Exercises_Defining_Classes.Google_07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String PersonName;
    private Car car;
    private Company company;
    private List<Parents> parentsList;
    private List<Pokemon> pokemonList;
    private List<Children> childrenList;

    public Person (String PersonName , Car car){
        this.PersonName=PersonName;
        this.car = car;
        this.company = null;
        this.parentsList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setParentsList(Parents parents) {
        this.parentsList.add(parents);
    }

    public void setPokemonList(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public void setChildrenList(Children children) {
        this.childrenList.add(children);
    }

    public Person (String PersonName , Company company){
        this.PersonName=PersonName;
        this.company = company;
        this.car = null;
        this.parentsList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getPersonName() {
        return PersonName;
    }

    public Person(String personName) {
        PersonName = personName;
        this.car = null;
        this.company=null;
        this.parentsList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public Car getCar() {
        return car;
    }

    public Company getCompany() {
        return company;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }
}
