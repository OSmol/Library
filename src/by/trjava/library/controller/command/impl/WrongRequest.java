package by.trjava.library.controller.command.impl;

import by.trjava.library.controller.command.ICommand;

public class WrongRequest implements ICommand {
    @Override
    public String execute(String request) {
        return extractRequestParameter(request);
    }

    private String extractRequestParameter(String request){
        return request.substring(request.indexOf(' '),request.indexOf(';'));
    }
}
