package org.example.command;

import org.example.entity.Application;

public abstract class Command {
    protected Application application;

    public void setApplication(Application application){
        this.application = application;
    }

    public abstract void execute();

}
