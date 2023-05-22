package JavaOOP.Encapsulation_Exercises.AnimalFarm_02;

class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if(name != null && name.trim().length() > 0){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }
    public void setAge(int age) {
        if(age >=0 && age<=15){
            this.age = age;
        }else{
            throw  new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }
    private double calculateProductPerDay(){
        if(age >= 0 && age <=5){
            return 2;
        }else if (age>=6 && age<=11){
            return 1;
        }else{
            return 0.75;
        }
    }
    public double productPerDay(){
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("JavaOOP.Encapsulation_Exercises.AnimalFarm_02.Chicken %s (age %d) can produce %.2f eggs per day.",name,age,productPerDay());
    }
}
