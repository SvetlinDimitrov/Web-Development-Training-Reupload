package org.example.factories;

import org.example.ShopFactory;
import org.example.headphones.Headphone;
import org.example.headphones.SharpHeadphone;
import org.example.keyboard.Keyboard;
import org.example.keyboard.SharpKeyboard;
import org.example.monitors.Monitor;
import org.example.monitors.SharpMonitors;

public class SharpShop extends ShopFactory {
    @Override
    protected Monitor getMonitor() {
        return new SharpMonitors();
    }

    @Override
    protected Keyboard getKeyboard() {
        return new SharpKeyboard();
    }

    @Override
    protected Headphone getHeadphone() {
        return new SharpHeadphone();
    }
}
