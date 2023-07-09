package org.example;

public class Main {
    public static void main(String[] args) {
            Solder solder = new Solder("Tosho");
            solder.createOperation();
            solder.executeOperation();
            solder.rankUp();
            solder.createOperation();
            solder.executeOperation();
            solder.rankUp();
            solder.executeOperation();
            solder.createOperation();
    }
}