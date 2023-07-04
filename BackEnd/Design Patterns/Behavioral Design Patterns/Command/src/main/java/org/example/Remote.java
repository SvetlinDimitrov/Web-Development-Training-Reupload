package org.example;

import org.example.command.Command;
import org.example.entity.Application;

public class Remote {
    private final Application application;
    private Command command;

    public Remote(Application application) {
        this.application = application;
    }

    public void setCommand(Command command){
        this.command = command;
        command.setApplication(application);
    }

    public void executeCommand(){
        command.execute();
    }
}
