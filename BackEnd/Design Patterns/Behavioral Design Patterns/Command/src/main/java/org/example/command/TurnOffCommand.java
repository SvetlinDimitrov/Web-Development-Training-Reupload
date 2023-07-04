package org.example.command;

import org.example.entity.Application;

public class TurnOffCommand extends Command {


    @Override
    public void execute() {
        application.turnOff();
    }
}
