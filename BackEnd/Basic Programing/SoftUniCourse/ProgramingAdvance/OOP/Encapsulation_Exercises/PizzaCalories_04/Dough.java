public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public void setFlourType(String flourType) {
        if(flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        }else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setBakingTechnique(String bakingTechnique) {
        if(bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")){
            this.bakingTechnique = bakingTechnique;
        }
    }

    public void setWeight(double weight) {
        if(weight <= 200 && weight>0){
            this.weight = weight;
        }else{
            throw  new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }
    public  double calculateCalories(){
        double flour = 0;
        switch (flourType){
            case "White":
                flour = 1.5;
                break;
            case "Wholegrain":
                flour = 1.0;
                break;
        }
        double tech =0;
        switch (bakingTechnique){
            case "Crispy":
                tech = 0.9;
                break;
            case "Chewy":
                tech =1.1;
                break;
            case "Homemade":
                tech = 1.0;
                break;
        }
        return 2* weight *tech*flour;
    }
}
