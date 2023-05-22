package JavaOOP.Working_with_Abstraction_Exercise.TrafficLights_04;

public class TrafficLight {
    private Light light;

    public TrafficLight(Light light){
        this.light = light;
    }

    public void changeColor(){
        switch (light){
            case RED :
                light = Light.GREEN;
                break;
            case GREEN:
                light = Light.YELLOW;
                break;
            case YELLOW:
                light = Light.RED;
                break;
        }
    }

    public Light getLight() {
        return light;
    }
}
