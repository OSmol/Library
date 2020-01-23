package by.trjava.library.controller.command.impl;

import by.trjava.library.controller.command.ICommand;
import by.trjava.library.service.ILibraryService;
import by.trjava.library.service.exception.ServiceException;
import by.trjava.library.service.factory.ServiceFactory;

public class ShowBook implements ICommand {

    @Override
    public String execute(String request) {

        String response;
        ILibraryService factory = ServiceFactory.getInstance().getLibraryService();

        try {
            response = factory.showAllAvailableBooks();
        } catch (ServiceException e) {
            response = "Error during showing operation!";
        }

        return response;
    }
}
