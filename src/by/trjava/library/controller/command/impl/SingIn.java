package by.trjava.library.controller.command.impl;

import by.trjava.library.controller.command.ICommand;
import by.trjava.library.service.IClientService;
import by.trjava.library.service.ServiceException;
import by.trjava.library.service.factory.ServiceFactory;

public class SingIn implements ICommand {

    private static final String RESPONSE1 = "Error during sing in procedure!";
    private static final String RESPONSE2 = "You are singed in";
    private static final String RESPONSE3 = "There is no user with this login or password!";

    @Override
    public String execute(String request) {

        String response;

        IClientService factory = ServiceFactory.getInstance().getClientService();

        try {
            response = defineResponse(factory.singIn(extractFirstParam(request), extractSecondParam(request)));

        } catch (ServiceException e) {
            response = RESPONSE1;
        }

        return response;
    }

    private String extractFirstParam(String request){
        String firstParam;

        firstParam = request.substring(request.indexOf(DELIMITER1)+1, request.indexOf(DELIMITER2));

        return firstParam;
    }

    private String extractSecondParam(String request){
        String secondParam;

        secondParam = request.substring(request.lastIndexOf(DELIMITER1)+1, request.lastIndexOf(DELIMITER2));

        return secondParam;
    }

    private String defineResponse(boolean result){
        String response;

        if(result == true)
            response = RESPONSE2;
        else response = RESPONSE3;

        return response;
    }
}
