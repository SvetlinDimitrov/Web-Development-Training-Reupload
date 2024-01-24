package org.example.anotherTry;

import java.util.ArrayList;
import java.util.List;

public class ListBuilderRooms {
    private List<Room> rooms = new ArrayList<>();

    public ListBuilderRooms addRoom (Room room) {
        rooms.add(room);
        return this;
    }

    public RoomBuilder addBuilderRoom(){
        return new RoomBuilder(this);
    }

    public List<Room> finishList(){
        return rooms;
    }
}
