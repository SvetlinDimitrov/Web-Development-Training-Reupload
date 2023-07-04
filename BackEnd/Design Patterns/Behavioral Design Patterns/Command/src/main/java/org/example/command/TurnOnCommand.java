package org.example.command;

import org.example.entity.Application;

public class TurnOnCommand extends Command {

    @Override
    public void execute() {
        application.turnOn();
    }

}
