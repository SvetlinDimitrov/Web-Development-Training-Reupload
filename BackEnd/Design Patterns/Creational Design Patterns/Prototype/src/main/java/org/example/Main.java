package org.example;

public class Main {
    public static class TV implements Cloneable {
        private String param1;
        private String param2;
        private String param3;

        public TV(String param1, String param2, String param3) {
            this.param1 = param1;
            this.param2 = param2;
            this.param3 = param3;
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

        @Override
        protected TV clone() throws CloneNotSupportedException {
            return (TV) super.clone();
        }
    }

    public static class Room implements Cloneable {

        private String value1;
        private String value2;
        private String value3;
        private TV tv;

        public Room(String value1, String value2, String value3, TV tv) {
            this.value1 = value1;
            this.value2 = value2;
            this.value3 = value3;
            this.tv = tv;
        }

        public String getValue1() {
            return value1;
        }

        public void setValue1(String value1) {
            this.value1 = value1;
        }

        public String getValue2() {
            return value2;
        }

        public void setValue2(String value2) {
            this.value2 = value2;
        }

        public String getValue3() {
            return value3;
        }

        public void setValue3(String value3) {
            this.value3 = value3;
        }

        public TV getTv() {
            return tv;
        }

        public void setTv(TV tv) {
            this.tv = tv;
        }

        @Override
        protected Room clone() throws CloneNotSupportedException {
            Room clone = (Room) super.clone();
            clone.setTv(tv.clone());
            return clone;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TV tv = new TV("Tushiba", "1250W", "HD");
        Room room = new Room("Blue wall", "something2", "something3", tv);
        Room clone = room.clone();
        clone.setValue1("something1");
        System.out.println(clone.getTv() == room.getTv());
    }
}