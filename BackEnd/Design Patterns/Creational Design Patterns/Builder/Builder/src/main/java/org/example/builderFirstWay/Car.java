package org.example.builderFirstWay;

public class Car {
    private String model;
    private Integer horsePower;
    private Integer doors;

    private Car() {}

    public String getModel() {
        return model;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public Integer getDoors() {
        return doors;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    private void setDoors(Integer doors) {
        this.doors = doors;
    }
    public static BuilderCar getBuilder(){
        return new BuilderCar();
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", doors=" + doors +
                '}';
    }

    public static class BuilderCar{
        private String model;
        private Integer horsePower;
        private Integer doors;

        private Car car;

        public BuilderCar setModel(String model) {
            this.model = model;
            return this;
        }

        public BuilderCar setHorsePower(Integer horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public BuilderCar setDoors(Integer doors) {
            this.doors = doors;
            return this;
        }

        public Car build(){
            car = new Car();
            car.setModel(model);
            car.setDoors(doors);
            car.setHorsePower(horsePower);
            return car;
        }
        public Car getCar(){
            return car;
        }
    }
}
