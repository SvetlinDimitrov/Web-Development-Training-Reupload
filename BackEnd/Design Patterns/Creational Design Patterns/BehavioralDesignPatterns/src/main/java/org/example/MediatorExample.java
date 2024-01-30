package org.example;

public class MediatorExample {
    abstract static class Player {
        protected final Mediator mediator;
        protected boolean madeAPass;
        protected boolean tookAPass;

        public boolean isMadeAPass() {
            return madeAPass;
        }

        public void setMadeAPass(boolean madeAPass) {
            this.madeAPass = madeAPass;
        }

        public boolean isTookAPass() {
            return tookAPass;
        }

        public void setTookAPass(boolean tookAPass) {
            this.tookAPass = tookAPass;
        }

        protected Player(Mediator mediator) {
            this.mediator = mediator;
        }

        abstract void MakePass();

        abstract void cachePass();
    }

    static class Player1 extends Player {


        protected Player1(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void MakePass() {
            System.out.println("Player1 made a pass to Player2");
            mediator.notify(this);
            setMadeAPass(true);
        }

        @Override
        public void cachePass() {
            System.out.println("Player1 caches pass from Player3");
            mediator.notify(this);
            setTookAPass(true);
        }
    }

    static class Player3 extends Player {

        protected Player3(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void MakePass() {
            System.out.println("Player3 made a pass to Player1");
            mediator.notify(this);
            setMadeAPass(true);
        }

        @Override
        public void cachePass() {
            System.out.println("Player3 caches pass from Player2");
            mediator.notify(this);
            setTookAPass(true);
        }
    }

    static class Player2 extends Player {

        protected Player2(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void MakePass() {
            System.out.println("Player2 made a pass to Player3");
            mediator.notify(this);
            setMadeAPass(true);
        }

        @Override
        public void cachePass() {
            System.out.println("Player2 caches pass from Player1");
            mediator.notify(this);
            setTookAPass(true);
        }
    }

    static class Mediator {
        private final Player1 player1 = new Player1(this);
        private final Player2 player2 = new Player2(this);
        private final Player3 player3 = new Player3(this);

        public void notify(Player player) {
            // Some action here
        }
    }


    public static void main(String[] args) {

    }
}
