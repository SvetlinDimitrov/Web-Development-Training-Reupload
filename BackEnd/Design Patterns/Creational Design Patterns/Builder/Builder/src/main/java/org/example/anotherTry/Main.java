package org.example.anotherTry;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Room room2 = Room.getBuilder()
                .setRoomNumber(16)
                .build();

        Room room = new RoomBuilder()
                .setRoomNumber(15)
                .setRoomType("Ladno")
                .build();

        List<Room> roomList = new ListBuilderRooms()
                .addBuilderRoom().setRoomNumber(16).addRoom()
                .addRoom(room)
                .addRoom(room2)
                .finishList();

        for(Room entity : roomList){
            System.out.println(entity);
        }

    }
}
