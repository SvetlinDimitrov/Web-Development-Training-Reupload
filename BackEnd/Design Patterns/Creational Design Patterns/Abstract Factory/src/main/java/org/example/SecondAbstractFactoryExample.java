package org.example;

public class SecondAbstractFactoryExample {
    interface GiveInfo {
        void giveInfo();
    }

    static abstract class Potato implements GiveInfo {
    }

    static class SweetPotato extends Potato {
        @Override
        public void giveInfo() {
            System.out.println("Perfect sweetPotatoes added");
        }
    }

    static class FriedPotato extends Potato {
        @Override
        public void giveInfo() {
            System.out.println("Fried potato added");
        }
    }

    static abstract class Cheese implements GiveInfo {
    }

    static class AmericanCheese extends Cheese {

        @Override
        public void giveInfo() {
            System.out.println("American cheese added");
        }
    }

    static class ChinesCheese extends Cheese {

        @Override
        public void giveInfo() {
            System.out.println("Chine Cheese added");
        }
    }

    static abstract class Cucumber implements GiveInfo {
    }

    static class SpicyCucumber extends Cucumber {

        @Override
        public void giveInfo() {
            System.out.println("Spicy cucumber was added");
        }
    }

    static class NormalCucumber extends Cucumber {

        @Override
        public void giveInfo() {
            System.out.println("Normal cucumber was added");
        }
    }

    static class Pica {
        private Potato potato;
        private Cheese cheese;
        private Cucumber cucumber;

        public void showFoodInfo() {
            potato.giveInfo();
            cheese.giveInfo();
            cucumber.giveInfo();
        }

        public Potato getPotato() {
            return potato;
        }

        public void setPotato(Potato potato) {
            this.potato = potato;
        }

        public Cheese getCheese() {
            return cheese;
        }

        public void setCheese(Cheese cheese) {
            this.cheese = cheese;
        }

        public Cucumber getCucumber() {
            return cucumber;
        }

        public void setCucumber(Cucumber cucumber) {
            this.cucumber = cucumber;
        }
    }

    static abstract class AbstractFactory {
        protected Pica pica = new Pica();

        protected abstract void addPotato();

        protected abstract void addCheese();

        protected abstract void addCucumber();

        public Pica createPica() {
            addPotato();
            addCheese();
            addCucumber();
            return pica;
        }

        public Pica getPica() {
            return pica;
        }

        public void setPica(Pica pica) {
            this.pica = pica;
        }
    }

    static class AmericanPicaFactory extends AbstractFactory {
        @Override
        public void addPotato() {
            Potato potato = new SweetPotato();
            pica.setPotato(potato);
        }

        @Override
        public void addCheese() {
            Cheese cheese = new AmericanCheese();
            pica.setCheese(cheese);
        }

        @Override
        public void addCucumber() {
            pica.setCucumber(new NormalCucumber());
        }
    }

    static class ChinesPicaFactory extends AbstractFactory {

        @Override
        public void addPotato() {
            pica.setPotato(new FriedPotato());
        }

        @Override
        public void addCheese() {
            pica.setCheese(new ChinesCheese());
        }

        @Override
        public void addCucumber() {
            pica.setCucumber(new SpicyCucumber());
        }
    }

    static class MixPicaFactory extends AbstractFactory {

        @Override
        public void addPotato() {
            pica.setPotato(new FriedPotato());
        }

        @Override
        public void addCheese() {
            pica.setCheese(new ChinesCheese());
        }

        @Override
        public void addCucumber() {
            pica.setCucumber(new NormalCucumber());
        }
    }

    public static void main(String[] args) {
        AbstractFactory americanPicaFactory = new AmericanPicaFactory();
        Pica pica = americanPicaFactory.createPica();
        pica.showFoodInfo();

        AbstractFactory chinesPicaFactory = new ChinesPicaFactory();
        Pica pica2 = chinesPicaFactory.createPica();
        pica2.showFoodInfo();

        AbstractFactory mixPicaFactory = new MixPicaFactory();
        Pica pica3 = mixPicaFactory.createPica();
        pica3.showFoodInfo();

    }

}
