package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager entity = Persistence.createEntityManagerFactory("entity").createEntityManager();
        BillingDetails b1 = new CreditCard();
        BillingDetails b2 = new BankAccount();
        entity.getTransaction().begin();
        entity.persist(b1);
        entity.persist(b2);
        entity.getTransaction().commit();
    }
}