package by.trjava.library.controller.command.impl;

import by.trjava.library.controller.command.ICommand;
import by.trjava.library.service.ILibraryService;
import by.trjava.library.service.*;
import by.trjava.library.service.factory.ServiceFactory;

public class ShowBook implements ICommand {

    private static final String RESPONSE1 = "Error during showing operation!";

    @Override
    public String execute(String request) {

        String response;
        ILibraryService factory = ServiceFactory.getInstance().getLibraryService();

        try {
            response = factory.showAllAvailableBooks();
        } catch (ServiceException e) {
            response = RESPONSE1;
        }

        return response;
    }
}
