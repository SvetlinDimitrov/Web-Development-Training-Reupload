package org.example;

import org.example.headphones.Headphone;
import org.example.keyboard.Keyboard;
import org.example.monitors.Monitor;

public abstract class ShopFactory {
    protected abstract Monitor getMonitor();
    protected abstract Keyboard getKeyboard();
    protected abstract Headphone getHeadphone();

    public void printCurrentStocks(){
        System.out.printf("%s are currently selling %s , %s ,%s %n" , this.getClass().getSimpleName(),
                getMonitor().getClass().getSimpleName(),
                getHeadphone().getClass().getSimpleName(),
                getKeyboard().getClass().getSimpleName());
    }
}
