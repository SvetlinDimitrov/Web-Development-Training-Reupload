package org.example;

public class EagerSingleton {
    private static final EagerSingleton EAGER_SINGLETON = new EagerSingleton();
    private EagerSingleton(){}

    public static EagerSingleton getEagerSingleton(){return EAGER_SINGLETON;}
}
