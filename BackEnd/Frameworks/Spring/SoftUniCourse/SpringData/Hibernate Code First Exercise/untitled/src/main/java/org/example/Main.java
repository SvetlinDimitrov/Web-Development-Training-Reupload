package org.example;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManager manager = Persistence.createEntityManagerFactory("entity").createEntityManager();


    }
}