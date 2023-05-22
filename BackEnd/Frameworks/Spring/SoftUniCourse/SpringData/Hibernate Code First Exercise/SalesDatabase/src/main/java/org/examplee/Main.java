package org.examplee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager entity = Persistence.createEntityManagerFactory("entity").createEntityManager();
    }
}