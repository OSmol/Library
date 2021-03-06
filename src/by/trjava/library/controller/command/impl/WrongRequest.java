package by.trjava.library.controller.command.impl;

import by.trjava.library.controller.command.ICommand;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WrongRequest implements ICommand{

    private static final char DELIMITER = ' ';
    private static final String RESPONSE = "Wrong request!";
    private static final String COMMAND = "WRONG_REQUEST";

    @Override
    public String execute(String request) {
        return extractRequestParameter(request);
    }

    private String extractRequestParameter(String request){

        if(!defineIsItWrongRequest(request))
            return RESPONSE;

        return request.substring(request.indexOf(DELIMITER),request.indexOf(DELIMITER2));
    }

    private boolean defineIsItWrongRequest(String request){

        Pattern pattern = Pattern.compile(COMMAND);
        Matcher matcher = pattern.matcher(request);

        if(!matcher.find())
            return false;

        return true;
    }
}
