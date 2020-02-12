package by.trjava.library.service.impl;

import by.trjava.library.bean.Book;
import by.trjava.library.dao.*;
import by.trjava.library.dao.factory.DAOFactory;
import by.trjava.library.service.ILibraryService;
import by.trjava.library.service.*;


public class LibraryServiceImpl implements ILibraryService {

    private final static String DELIMITER1 = "'";
    private final static String DELIMITER2 = " ";

    @Override
    public boolean take(Book book) throws ServiceException {

        IBookDAO factory = DAOFactory.getInstance().getBookDAO();

        try {
            if (bookExistenceCheckForTaking(book, factory)) {
                factory.take(book);
                return true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error!Unable to take this book!");
        }

        return false;
    }

    @Override
    public boolean giveBack(Book book) throws ServiceException {

        IBookDAO factory = DAOFactory.getInstance().getBookDAO();

        try {
            if (bookExistenceCheckForGivingBack(book, factory)) {
                factory.giveBack(book);
                return true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error!Unable to give back this book!");
        }

        return false;
    }

    @Override
    public String showAllAvailableBooks() throws ServiceException {

        IBookDAO factory = DAOFactory.getInstance().getBookDAO();

        try {
            return  factory.getAvailableBooks();

        } catch (DAOException e) {
            throw new ServiceException("Error!Unable to show books");
        }
    }

    private boolean bookExistenceCheckForTaking(Book book, IBookDAO factory) throws  DAOException {

        if (factory.getAvailableBooks().contains(book.getAuthor() + DELIMITER2 + DELIMITER1 + book.getBookName() + DELIMITER1))
                return true;

        return false;
    }

    private boolean bookExistenceCheckForGivingBack(Book book, IBookDAO factory) throws  DAOException {

        if (factory.getTakenBooks().contains(book.getAuthor() + DELIMITER2 + DELIMITER1 + book.getBookName() + DELIMITER1))
            return true;

        return false;
    }
}