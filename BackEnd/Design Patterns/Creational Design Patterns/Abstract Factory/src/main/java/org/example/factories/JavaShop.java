package org.example.factories;

import org.example.ShopFactory;
import org.example.headphones.Headphone;
import org.example.headphones.JavaHeadphone;
import org.example.keyboard.JavaKeyboard;
import org.example.keyboard.Keyboard;
import org.example.monitors.JavaMonitors;
import org.example.monitors.Monitor;

public class JavaShop extends ShopFactory {
    @Override
    protected Monitor getMonitor() {
        return new JavaMonitors();
    }

    @Override
    protected Keyboard getKeyboard() {
        return new JavaKeyboard();
    }

    @Override
    protected Headphone getHeadphone() {
        return new JavaHeadphone();
    }
}
