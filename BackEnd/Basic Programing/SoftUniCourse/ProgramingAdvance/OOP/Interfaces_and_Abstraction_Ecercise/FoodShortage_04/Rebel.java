public class Rebel implements Buyer , Person{
    private String name;
    private int age;
    private String group;
    private static final int FOOD_CONSUME =5;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public void buyFood() {
        System.out.println(getName());
    }

    @Override
    public int getFood() {
        return  FOOD_CONSUME;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }
}
