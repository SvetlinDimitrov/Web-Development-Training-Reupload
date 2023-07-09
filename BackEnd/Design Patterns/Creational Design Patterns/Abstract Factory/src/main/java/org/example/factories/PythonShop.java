package org.example.factories;

import org.example.ShopFactory;
import org.example.headphones.Headphone;
import org.example.headphones.PythonHeadphone;
import org.example.keyboard.Keyboard;
import org.example.keyboard.PythonKeyboard;
import org.example.monitors.Monitor;
import org.example.monitors.PythonMonitors;

public class PythonShop extends ShopFactory {
    @Override
    protected Monitor getMonitor() {
        return new PythonMonitors();
    }

    @Override
    protected Keyboard getKeyboard() {
        return new PythonKeyboard();
    }

    @Override
    protected Headphone getHeadphone() {
        return new PythonHeadphone();
    }
}
