package org.example.anotherTry;

public class RoomBuilder {
    private Room room = new Room();
    private ListBuilderRooms list;

    public RoomBuilder(ListBuilderRooms listBuilderRooms) {
        this.list = listBuilderRooms;
    }

    public RoomBuilder() {
    }

    public RoomBuilder setRoomNumber(int roomNumber) {
        room.setRoomNumber(roomNumber);
        return this;
    }

    public RoomBuilder setRoomType(String roomType) {
        room.setRoomType(roomType);
        return this;
    }

    public Room build() {
        return room;
    }

    public ListBuilderRooms addRoom() {
        this.list.addRoom(room);
        return list;
    }
}