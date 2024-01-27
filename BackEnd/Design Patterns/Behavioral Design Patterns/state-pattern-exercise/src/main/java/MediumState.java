public class MediumState implements State{
    @Override
    public void turnUp(Fan fan) {
        System.out.println("Fan is on high");
        fan.setState(new HighState());
    }

    @Override
    public void turnDown(Fan fan) {
        System.out.println("Fan is on low");
        fan.setState(new LowState());
    }
}
