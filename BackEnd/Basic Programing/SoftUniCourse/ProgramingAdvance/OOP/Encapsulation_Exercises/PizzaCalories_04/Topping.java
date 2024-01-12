public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if(toppingType.equals("Meat") || toppingType.equals("Veggies")
        || "Cheese".equals(toppingType) || "Sauce".equals(toppingType)){
            this.toppingType = toppingType;
        }else{
            String print = String.format("Cannot place %s on top of your pizza.",toppingType);
            throw new IllegalArgumentException(print);
        }
    }

    public void setWeight(double weight) {
        if(weight >=1 && weight<=50){
            this.weight = weight;
        }else{
            String print = String.format("%s weight should be in the range [1..50].",toppingType);
            throw  new IllegalArgumentException(print);
        }
    }
    public double calculateCalories(){
        double topping = 0;
        switch (toppingType){
            case "Meat":
                topping=1.2;
                break;
            case "Veggies":
                topping=0.8;
                break;
            case"Cheese":
                topping = 1.1;
                break;
            case "Sauce":
                topping = 0.9;
                break;
        }
        return topping*2*weight;
    }
}
