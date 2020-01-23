package by.trjava.library.controller.command.impl;

import by.trjava.library.controller.command.ICommand;

public class WrongRequest implements ICommand{

    private static final char DELIMITER1 = ' ';
    private static final char DELIMITER2 = ';';

    @Override
    public String execute(String request) {
        return extractRequestParameter(request);
    }

    private String extractRequestParameter(String request){
        return request.substring(request.indexOf(DELIMITER1),request.indexOf(DELIMITER2));
    }
}
