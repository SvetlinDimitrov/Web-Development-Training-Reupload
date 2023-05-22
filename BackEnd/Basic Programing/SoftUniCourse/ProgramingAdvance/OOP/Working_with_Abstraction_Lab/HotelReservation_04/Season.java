package JavaOOP.Working_with_Abstraction_Lab.HotelReservation_04;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);
    private int value;
    Season(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
