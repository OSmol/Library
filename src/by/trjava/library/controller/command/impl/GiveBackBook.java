package by.trjava.library.controller.command.impl;

import by.trjava.library.bean.Book;
import by.trjava.library.controller.command.ICommand;
import by.trjava.library.service.ILibraryService;
import by.trjava.library.service.exception.ServiceException;
import by.trjava.library.service.factory.ServiceFactory;

public class GiveBackBook implements ICommand{

    private static final char DELIMITER1 = '=';
    private static final char DELIMITER2 = ';';

    @Override
    public String execute(String request) {

        String response;

        ILibraryService factory = ServiceFactory.getInstance().getLibraryService();
        Book book = new Book(extractFirstParam(request), extractSecondParam(request));//??

        try {

            response = defineResponse(factory.giveBack(book));

        } catch (ServiceException e) {
            response = "Error during giving back procedure!";
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
            response = "The book is given back";
        else response = "You didn`t take this book!";

        return response;
    }
}
