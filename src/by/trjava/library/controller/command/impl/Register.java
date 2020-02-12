package by.trjava.library.controller.command.impl;

import by.trjava.library.bean.User;
import by.trjava.library.controller.command.ICommand;
import by.trjava.library.service.IClientService;
import by.trjava.library.service.ServiceException;
import by.trjava.library.service.factory.ServiceFactory;

public class Register implements ICommand {

    private static final String RESPONSE1 = "Error during registration procedure";
    private static final String RESPONSE2 = "Registration completed!";
    private static final String RESPONSE3 = "Sorry! There is a user with the same login!";

    @Override
    public String execute(String request) {

        String response;

        IClientService factory = ServiceFactory.getInstance().getClientService();
        User user = new User(extractFirstParam(request), extractSecondParam(request));

        try {
            response = defineResponse(factory.registration(user));
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

        String response = "";

        if(result == true)
            response = RESPONSE2;
        if (result == false)
            response = RESPONSE3;

        return response;
    }
}
