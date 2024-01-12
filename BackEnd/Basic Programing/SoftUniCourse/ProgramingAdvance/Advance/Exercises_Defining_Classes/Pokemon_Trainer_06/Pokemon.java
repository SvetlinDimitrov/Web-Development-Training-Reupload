package JavaAdvance.Exercises_Defining_Classes.Pokemon_Trainer_06;

public class Pokemon {
    private String name;
    private String element;
    private int hp;

    public Pokemon(String name, String element, int hp) {
        this.name = name;
        this.element = element;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public void loseHp(int dmg){
       this.hp -=dmg;
    }

    public int getHp() {
        return hp;
    }
}
