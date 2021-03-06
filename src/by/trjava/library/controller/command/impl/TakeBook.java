package by.trjava.library.controller.command.impl;

import by.trjava.library.bean.Book;
import by.trjava.library.controller.command.ICommand;
import by.trjava.library.service.ILibraryService;
import by.trjava.library.service.*;
import by.trjava.library.service.factory.ServiceFactory;

public class TakeBook implements ICommand {

    private static final String RESPONSE1 = "Error during taken book procedure!";
    private static final String RESPONSE2 = "Now this book is yours!";
    private static final String RESPONSE3 = "Sorry, you can`t take this book!";

    @Override
    public String execute(String request) {

        String response;

        ILibraryService factory = ServiceFactory.getInstance().getLibraryService();
        Book book = new Book(extractFirstParam(request), extractSecondParam(request));

        try {

            response = defineResponse(factory.take(book));

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
