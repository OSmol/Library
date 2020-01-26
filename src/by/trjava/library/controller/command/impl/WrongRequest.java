package by.trjava.library.controller.command.impl;

import by.trjava.library.controller.command.ICommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WrongRequest implements ICommand{

    private static final char DELIMITER1 = ' ';
    private static final char DELIMITER2 = ';';

    @Override
    public String execute(String request) {
        return extractRequestParameter(request);
    }

    private String extractRequestParameter(String request){

        if(!defineIsItWrongRequest(request))
            return "Wrong request!";

        return request.substring(request.indexOf(DELIMITER1),request.indexOf(DELIMITER2));
    }

    private boolean defineIsItWrongRequest(String request){

        Pattern pattern = Pattern.compile("WRONG_REQUEST");
        Matcher matcher = pattern.matcher(request);

        if(!matcher.find())
            return false;

        return true;
    }
}
