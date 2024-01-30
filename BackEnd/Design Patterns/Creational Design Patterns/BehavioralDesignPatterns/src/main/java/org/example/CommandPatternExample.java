package org.example;

public class CommandPatternExample {
    static class TV {
        public void turnOn() {
            System.out.println("Turn on tv");
        }

        public void turnOff() {
            System.out.println("TV is turned off");
        }
    }

    interface Command {
        void execute(TV tv);
    }

    static class Remote {
        private final TV tv;

        Remote(TV tv) {
            this.tv = tv;
        }

        public void execute(Command command) {
            command.execute(tv);
        }

    }

    static class TurnOffTv implements Command {

        @Override
        public void execute(TV tv) {
            tv.turnOff();
        }
    }

    static class TurnOnTv implements Command {

        @Override
        public void execute(TV tv) {
            tv.turnOn();
        }
    }

    public static void main(String[] args) {
        TV tv = new TV();
        Remote remote = new Remote(tv);

        remote.execute(new TurnOffTv());
        remote.execute(new TurnOnTv());
    }
}
