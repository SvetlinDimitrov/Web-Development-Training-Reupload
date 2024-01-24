package org.example.anotherTry;

public class Room {
    public static class RoomBuilder2 {
        private Room room = new Room();

        public RoomBuilder2 setRoomNumber(int roomNumber){
            room.setRoomNumber(roomNumber);
            return this;
        }

        public RoomBuilder2 setRoomType (String roomType){
            room.setRoomType(roomType);
            return this;
        }

        public Room build(){
            return room;
        }
    }

    private int roomNumber;

    private String roomType;

    private int capacity;

    private boolean isOccupied;

    private double pricePerNight;

    public Room () {};

    public static RoomBuilder2 getBuilder(){
        return new RoomBuilder2();
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", capacity=" + capacity +
                ", isOccupied=" + isOccupied +
                ", pricePerNight=" + pricePerNight +
                '}';
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
