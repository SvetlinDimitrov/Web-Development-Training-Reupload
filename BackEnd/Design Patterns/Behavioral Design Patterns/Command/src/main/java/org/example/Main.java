package org.example;

import org.example.command.TurnOffCommand;
import org.example.command.TurnOnCommand;
import org.example.entity.Tv;

public class Main {
    public static void main(String[] args) {
        Remote remote = new Remote(new Tv());
        remote.setCommand(new TurnOnCommand());
        remote.executeCommand();
        remote.setCommand(new TurnOffCommand());
        remote.executeCommand();
    }
}