public class LowState implements State {

    @Override
    public void turnUp(Fan fan) {
        System.out.println("Fan is on medium");
        fan.setState(new MediumState());
    }

    @Override
    public void turnDown(Fan fan) {

    }
}
