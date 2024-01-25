package org.example.anotherTry;

import java.util.ArrayList;
import java.util.List;

public class Main {
    interface RoomBuilder {
        RoomBuilder setParam1(String value1);

        RoomBuilder setParam2(String value2);

        RoomBuilder setParam3(String value3);

        RoomBuilder setParam4(String value4);

        Room build();
    }

    static abstract class Room {
        protected String param1;
        protected String param2;
        protected String param3;
        protected String param4;

        protected Room() {
        }

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public String getParam2() {
            return param2;
        }

        public void setParam2(String param2) {
            this.param2 = param2;
        }

        public String getParam3() {
            return param3;
        }

        public void setParam3(String param3) {
            this.param3 = param3;
        }

        public String getParam4() {
            return param4;
        }

        public void setParam4(String param4) {
            this.param4 = param4;
        }
    }

    static class RoomListBuilder {
        private final List<Room> rooms = new ArrayList<>();
        public RoomListBuilder addRoom(Room room) {
            rooms.add(room);
            return this;
        }

        public List<Room> build() {
            return rooms;
        }
    }

    static class BathroomBuilder implements RoomBuilder {

        private final Bathroom bathroom = new Bathroom();

        @Override
        public BathroomBuilder setParam1(String value1) {
            bathroom.setParam1(value1);
            return this;
        }

        @Override
        public BathroomBuilder setParam2(String value2) {
            bathroom.setParam2(value2);
            return this;
        }

        @Override
        public BathroomBuilder setParam3(String value3) {
            bathroom.setParam3(value3);
            return this;
        }

        @Override
        public BathroomBuilder setParam4(String value4) {
            bathroom.setParam4(value4);
            return this;
        }

        @Override
        public Bathroom build() {
            return bathroom;
        }

        public BathroomBuilder setParam10(String value10) {
            bathroom.setParam10(value10);
            return this;
        }

    }

    static class BedroomBuilder implements RoomBuilder {

        private final Bedroom bedroom = new Bedroom();

        @Override
        public BedroomBuilder setParam1(String value1) {
            bedroom.setParam1(value1);
            return this;
        }

        @Override
        public BedroomBuilder setParam2(String value2) {
            bedroom.setParam2(value2);
            return this;
        }

        @Override
        public BedroomBuilder setParam3(String value3) {
            bedroom.setParam3(value3);
            return this;
        }

        @Override
        public BedroomBuilder setParam4(String value4) {
            bedroom.setParam4(value4);
            return this;
        }

        public BedroomBuilder setParam12(String value12) {
            bedroom.setParam12(value12);
            return this;
        }

        @Override
        public Bedroom build() {
            return bedroom;
        }
    }

    static class Bathroom extends Room {
        private String param10;

        public String getParam10() {
            return param10;
        }

        public void setParam10(String param10) {
            this.param10 = param10;
        }

        @Override
        public String toString() {
            return "Bathroom{" +
                    "param10='" + param10 + '\'' +
                    ", param1='" + param1 + '\'' +
                    ", param2='" + param2 + '\'' +
                    ", param3='" + param3 + '\'' +
                    ", param4='" + param4 + '\'' +
                    '}';
        }
    }

    static class Bedroom extends Room {
        private String param12;

        public String getParam12() {
            return param12;
        }

        public void setParam12(String param12) {
            this.param12 = param12;
        }

        @Override
        public String toString() {
            return "Bedroom{" +
                    "param12='" + param12 + '\'' +
                    ", param1='" + param1 + '\'' +
                    ", param2='" + param2 + '\'' +
                    ", param3='" + param3 + '\'' +
                    ", param4='" + param4 + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
//        //without Builder pattern
//        Bathroom bathroom = new Bathroom();
//        bathroom.setParam1("Value1");
//        bathroom.setParam2("Value2");
//        bathroom.setParam3("Value3");
//        bathroom.setParam4("Value4");
//        bathroom.setParam10("Value10");
//
//        Bedroom bedroom = new Bedroom();
//        bedroom.setParam1("Value1");
//        bedroom.setParam2("Value2");
//        bedroom.setParam3("Value3");
//        bedroom.setParam4("Value4");
//        bedroom.setParam12("Value12");
//
//        List<Room> roomList = new ArrayList<>();
//        roomList.add(bathroom);
//        roomList.add(bedroom);

////        With builder
//        Bathroom bathroom =  new BathroomBuilder().setParam1("Value1").setParam2("Value2")
//                .setParam3("Value3").setParam4("Value4").setParam10("Value10").build();
//        Bedroom bedroom = new BedroomBuilder().setParam1("Value1").setParam2("Value2")
//                .setParam3("Value3").setParam4("Value4").setParam12("Value12").build();
//
//        List<Room> rooms = new ArrayList<>();
//        rooms.add(bathroom);
//        rooms.add(bedroom);
//        for (Room room : rooms){
//            System.out.println(room);
//        }

////                With builder go further;
//        List<Room> rooms = new RoomListBuilder()
//                .addRoom(new BathroomBuilder().setParam1("Value1").setParam2("Value2")
//                        .setParam3("Value3").setParam4("Value4").setParam10("Value10").build())
//                .addRoom(new BedroomBuilder().setParam1("Value1").setParam2("Value2")
//                        .setParam3("Value3").setParam4("Value4").setParam12("Value12").build())
//                .build();
//        for (Room room : rooms){
//            System.out.println(room);
//        }


    }
}
