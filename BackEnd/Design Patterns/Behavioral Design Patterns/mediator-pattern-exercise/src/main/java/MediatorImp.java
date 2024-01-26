public class MediatorImp {
    private final Plane plane;
    private final PlanesInFlight planesInFlight = new PlanesInFlight();
    private final PlanesOnGround planesOnGround= new PlanesOnGround();
    private final Runway runway = new Runway();

    public MediatorImp (int id){
        plane = new Plane(id);
        planesOnGround.addPlane(plane);
    }
    public void takeOff() {
        if (!plane.getIsInTheAir() && runway.getIsAvailable()) {
            System.out.println("Plane " + plane.getId() + " is taking off...");
            planesOnGround.removePlane(plane);
            planesInFlight.addPlane(plane);
            plane.setIsInTheAir(true);
            runway.setIsAvailable(false);
        }
    }
}
