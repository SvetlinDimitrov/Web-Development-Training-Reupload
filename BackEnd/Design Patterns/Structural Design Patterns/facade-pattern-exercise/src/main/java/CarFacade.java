public class CarFacade {
    private final Ignition ignition;
    private final Clutch clutch ;
    private final Accelerator accelerator;
    private final GearStick gearStick ;
    private final Handbrake handbrake;

    public CarFacade() {
        this.ignition = new Ignition();
        this.clutch = new Clutch();
        this.accelerator = new Accelerator();
        this.gearStick = new GearStick();
        this.handbrake = new Handbrake();
    }

    public void doWork(){
        ignition.turnOn();
        clutch.press();
        gearStick.changeGear(1);
        accelerator.press();
        clutch.lift();
        handbrake.pushDown();
        accelerator.press();
        clutch.press();
    }
}
