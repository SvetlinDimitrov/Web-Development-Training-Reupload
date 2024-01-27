public class HighState implements State{

    @Override
    public void turnUp(Fan fan) {

    }

    @Override
    public void turnDown(Fan fan) {
        System.out.println("Fan is on medium");
       fan.setState(new MediumState());
    }
}
